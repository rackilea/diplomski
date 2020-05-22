import org.glassfish.jersey.server.ResourceConfig;

public class MyResourceConfig extends ResourceConfig {

    public MyResourceConfig() {
        packages(new String[] { 
            "path.to.foo", 
            "path.to.bar"
        });
    }
}