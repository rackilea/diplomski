@javax.ws.rs.ApplicationPath("api")
public class ApplicationConfig extends ResourceConfig {

public ApplicationConfig() {
    packages("com.test.thepackage.service");
    register(MultiPartFeature.class);
}