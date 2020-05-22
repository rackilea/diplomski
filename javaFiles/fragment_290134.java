import java.util.HashMap;
import java.util.Map;
import javax.ws.rs.core.Configuration;
import javax.ws.rs.ext.Provider;
import org.glassfish.jersey.server.model.ModelProcessor;
import org.glassfish.jersey.server.model.Resource;
import org.glassfish.jersey.server.model.ResourceModel;

@Provider
public class VersioningModelProcessor implements ModelProcessor {

    private Map<String, String> packageAppenders = new HashMap<>();

    {
        packageAppenders.put("com.stackoverflow.jersey.v1", "v1");
        packageAppenders.put("com.stackoverflow.jersey.v2", "v2");
    }

    @Override
    public ResourceModel processResourceModel(ResourceModel model, Configuration config) {

        // Create new resourc model.
        ResourceModel.Builder newModelBuilder = new ResourceModel.Builder(false);
        for (final Resource resource: model.getResources()) {

            // Look for the package
            String path = resource.getPath();
            Class handlerClass = resource.getHandlerClasses().iterator().next();
            String pkg = handlerClass.getPackage().getName();

            // Match the packge to our map of packages
            if (packageAppenders.containsKey(pkg)) {

                // append the version
                String version = packageAppenders.get(pkg);
                path = version + "/" + path.replace("/", "");

                Resource.Builder resourceBuilder = Resource.builder(resource);
                resourceBuilder.path(path);

                Resource newResource = resourceBuilder.build();
                System.out.println(newResource.toString());

                // add the new resource with the new path.
                newModelBuilder.addResource(newResource);
            } else {
                // Do nothing. Just add the resource as normal
                newModelBuilder.addResource(resource);
            }
        }
        return newModelBuilder.build();
    }

    @Override
    public ResourceModel processSubResource(ResourceModel model, Configuration config) {
        return model;
    }
}