import java.util.ArrayList;
import java.util.List;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.elasticmapreduce.AmazonElasticMapReduceClient;
import com.amazonaws.services.elasticmapreduce.model.BootstrapActionConfig;
import com.amazonaws.services.elasticmapreduce.model.JobFlowInstancesConfig;
import com.amazonaws.services.elasticmapreduce.model.RunJobFlowRequest;
import com.amazonaws.services.elasticmapreduce.model.RunJobFlowResult;
import com.amazonaws.services.elasticmapreduce.model.ScriptBootstrapActionConfig;
import com.amazonaws.services.elasticmapreduce.model.StepConfig;
import com.amazonaws.services.elasticmapreduce.util.StepFactory;

/**
 * 
 * @author amar
 * 
 */
public class RunEMRJobFlow {

    private static final String CONFIG_HADOOP_BOOTSTRAP_ACTION = "s3://elasticmapreduce/bootstrap-actions/configure-hadoop";

    public static void main(String[] args) {

        String accessKey = "";
        String secretKey = "";
        AWSCredentials credentials = new BasicAWSCredentials(accessKey, secretKey);
        AmazonElasticMapReduceClient emr = new AmazonElasticMapReduceClient(credentials);

        StepFactory stepFactory = new StepFactory();

        StepConfig enabledebugging = new StepConfig().withName("Enable debugging")
                .withActionOnFailure("TERMINATE_JOB_FLOW").withHadoopJarStep(stepFactory.newEnableDebuggingStep());

        StepConfig installHive = new StepConfig().withName("Install Hive").withActionOnFailure("TERMINATE_JOB_FLOW")
                .withHadoopJarStep(stepFactory.newInstallHiveStep());
        List<String> setMappersArgs = new ArrayList<String>();
        setMappersArgs.add("-s");
        setMappersArgs.add("textinputformat.record.delimiter=;");

        BootstrapActionConfig mappersBootstrapConfig = createBootstrapAction("Set Hadoop Config",
                CONFIG_HADOOP_BOOTSTRAP_ACTION, setMappersArgs);

        RunJobFlowRequest request = new RunJobFlowRequest()
                .withBootstrapActions(mappersBootstrapConfig)
                .withName("Hive Interactive")
                .withSteps(enabledebugging, installHive)
                .withLogUri("s3://myawsbucket/")
                .withInstances(
                        new JobFlowInstancesConfig().withEc2KeyName("keypair").withHadoopVersion("0.20")
                                .withInstanceCount(5).withKeepJobFlowAliveWhenNoSteps(true)
                                .withMasterInstanceType("m1.small").withSlaveInstanceType("m1.small"));

        RunJobFlowResult result = emr.runJobFlow(request);
    }

    private static BootstrapActionConfig createBootstrapAction(String bootstrapName, String bootstrapPath,
            List<String> args) {

        ScriptBootstrapActionConfig bootstrapScriptConfig = new ScriptBootstrapActionConfig();
        bootstrapScriptConfig.setPath(bootstrapPath);

        if (args != null) {
            bootstrapScriptConfig.setArgs(args);
        }

        BootstrapActionConfig bootstrapConfig = new BootstrapActionConfig();
        bootstrapConfig.setName(bootstrapName);
        bootstrapConfig.setScriptBootstrapAction(bootstrapScriptConfig);

        return bootstrapConfig;
    }

}