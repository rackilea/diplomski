package ny.devtest.endtoend.config;

import org.glassfish.jersey.server.ResourceConfig;
import ...

public class ApplicationConfig  extends ResourceConfig {

    private void ApplicationInit(){
        // Resources.
        packages(OrderResource.class.getPackage().getName());

        // Register CORS filter.
        register(ny.devtest.endtoend.ResponseCorsFilter.class);

        // Register the rest you need
        ...

    }

     public ApplicationConfig() {
        ApplicationInit();
        // Bindings (@Inject)
        register(new ApplicationBinder());
    }
   ...
}