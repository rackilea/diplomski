import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.Response;
import org.glassfish.hk2.api.Factory;
import org.glassfish.hk2.utilities.binding.AbstractBinder;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.junit.Assert;
import org.junit.Test;

public class InjectionTest extends JerseyTest {

    @Path("test")
    public static class SimpleResource {

        @Inject
        @Named("Oracle")
        private Repository repo;

        @GET
        public String getRepoName() {
            return repo.getClass().getSimpleName();
        }
    }

    @Override
    public Application configure() {
        ResourceConfig config = new ResourceConfig();
        config.register(SimpleResource.class);
        config.register(new AbstractBinder(){
            @Override
            protected void configure() {
                bindFactory(SqlFactory.class)
                        .to(Repository.class).named("Sql");
                bindFactory(OracleFactory.class)
                        .to(Repository.class).named("Oracle");
            }
        });
        return config;       
    }


    public static interface Repository {}

    public static class OracleRepository implements Repository {}

    public static class SqlRepository implements Repository {}

    public static class SqlFactory implements Factory<Repository> {

        @Override
        public Repository provide() {
            return new SqlRepository();
        }

        @Override
        public void dispose(Repository t) {}
    }

    public static class OracleFactory implements Factory<Repository> {

        @Override
        public Repository provide() {
            return new OracleRepository();
        }

        @Override
        public void dispose(Repository t) {}
    }

    /**
     * Change the `Assert` from "OracleRepository" to "SqlRepository"
     * when switching the `@Named` on the injection point.
     */
    @Test
    public void testInjectOk() {
        Response response = target("test").request().get();
        String respString = response.readEntity(String.class);
        Assert.assertEquals("OracleRepository", respString);
        System.out.println(respString);
    }
}