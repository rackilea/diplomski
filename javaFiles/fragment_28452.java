package br.com.ingenieux.resource;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.apache.commons.io.IOUtils;

import com.amazonaws.services.ec2.AmazonEC2;
import com.amazonaws.services.ec2.model.CreateTagsRequest;
import com.amazonaws.services.ec2.model.DeleteTagsRequest;
import com.amazonaws.services.ec2.model.DescribeInstancesRequest;
import com.amazonaws.services.ec2.model.Filter;
import com.amazonaws.services.ec2.model.Instance;
import com.amazonaws.services.ec2.model.Reservation;
import com.amazonaws.services.ec2.model.Tag;
import com.amazonaws.services.elasticbeanstalk.AWSElasticBeanstalk;
import com.amazonaws.services.elasticbeanstalk.model.DescribeEnvironmentsRequest;

@Path("/admin/leader")
public class LeaderResource extends BaseResource {
    @Inject
    AmazonEC2 amazonEC2;

    @Inject
    AWSElasticBeanstalk elasticBeanstalk;

    @GET
    public String getLeader() throws Exception {
        /*
         * Avoid running if we're not in AWS after all
         */
        try {
            IOUtils.toString(new URL(
                    "http://169.254.169.254/latest/meta-data/instance-id")
                    .openStream());
        } catch (Exception exc) {
            return "i-FFFFFFFF/localhost";
        }

        String environmentName = getMyEnvironmentName();

        List<Instance> environmentInstances = getInstances(
                "tag:elasticbeanstalk:environment-name", environmentName,
                "tag:leader", "true");

        if (environmentInstances.isEmpty()) {
            environmentInstances = getInstances(
                    "tag:elasticbeanstalk:environment-name", environmentName);

            Collections.shuffle(environmentInstances);

            if (environmentInstances.size() > 1)
                environmentInstances.removeAll(environmentInstances.subList(1,
                        environmentInstances.size()));

            amazonEC2.createTags(new CreateTagsRequest().withResources(
                    environmentInstances.get(0).getInstanceId()).withTags(
                    new Tag("leader", "true")));
        } else if (environmentInstances.size() > 1) {
            DeleteTagsRequest deleteTagsRequest = new DeleteTagsRequest().withTags(new Tag().withKey("leader").withValue("true"));

            for (Instance i : environmentInstances.subList(1,
                        environmentInstances.size())) {
                deleteTagsRequest.getResources().add(i.getInstanceId());
            }

            amazonEC2.deleteTags(deleteTagsRequest);
        }

        return environmentInstances.get(0).getInstanceId() + "/" + environmentInstances.get(0).getPublicIpAddress();
    }

    @GET
    @Produces("text/plain")
    @Path("am-i-a-leader")
    public boolean isLeader() {
        /*
         * Avoid running if we're not in AWS after all
         */
        String myInstanceId = null;
        String environmentName = null;
        try {
            myInstanceId = IOUtils.toString(new URL(
                    "http://169.254.169.254/latest/meta-data/instance-id")
                    .openStream());

            environmentName = getMyEnvironmentName();
        } catch (Exception exc) {
            return false;
        }

        List<Instance> environmentInstances = getInstances(
                "tag:elasticbeanstalk:environment-name", environmentName,
                "tag:leader", "true", "instance-id", myInstanceId);

        return (1 == environmentInstances.size());
    }

    protected String getMyEnvironmentHost(String environmentName) {
        return elasticBeanstalk
                .describeEnvironments(
                        new DescribeEnvironmentsRequest()
                                .withEnvironmentNames(environmentName))
                .getEnvironments().get(0).getCNAME();
    }

    private String getMyEnvironmentName() throws IOException,
            MalformedURLException {
        String instanceId = IOUtils.toString(new URL(
                "http://169.254.169.254/latest/meta-data/instance-id"));

        /*
         * Grab the current environment name
         */
        DescribeInstancesRequest request = new DescribeInstancesRequest()
                .withInstanceIds(instanceId)
                .withFilters(
                        new Filter("instance-state-name").withValues("running"));

        for (Reservation r : amazonEC2.describeInstances(request)
                .getReservations()) {
            for (Instance i : r.getInstances()) {
                for (Tag t : i.getTags()) {
                    if ("elasticbeanstalk:environment-name".equals(t.getKey())) {
                        return t.getValue();
                    }
                }
            }
        }

        return null;
    }

    public List<Instance> getInstances(String... args) {
        Collection<Filter> filters = new ArrayList<Filter>();

        filters.add(new Filter("instance-state-name").withValues("running"));

        for (int i = 0; i < args.length; i += 2) {
            String key = args[i];
            String value = args[1 + i];

            filters.add(new Filter(key).withValues(value));
        }

        DescribeInstancesRequest req = new DescribeInstancesRequest()
                .withFilters(filters);
        List<Instance> result = new ArrayList<Instance>();

        for (Reservation r : amazonEC2.describeInstances(req).getReservations())
            result.addAll(r.getInstances());

        return result;
    }
}