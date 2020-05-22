package hello;

import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.factory.GraphDatabaseFactory;
import org.neo4j.kernel.GraphDatabaseAPI;
import org.neo4j.server.WrappingNeoServerBootstrapper;
import org.neo4j.server.configuration.Configurator;
import org.neo4j.server.configuration.ServerConfigurator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.neo4j.config.EnableNeo4jRepositories;
import org.springframework.data.neo4j.config.Neo4jConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestMvcConfiguration;

@Configuration
@EnableNeo4jRepositories
@Import(RepositoryRestMvcConfiguration.class)
@EnableAutoConfiguration
public class Application extends Neo4jConfiguration implements CommandLineRunner{

    public Application() {
        setBasePackage("hello");
    }

    @Bean(destroyMethod = "shutdown")
    public GraphDatabaseService graphDatabaseService() {
        return new GraphDatabaseFactory().newEmbeddedDatabase("target/hello.db");
    }

    @Autowired
    GraphDatabaseService db;



    @Override
    public void run(String... strings) throws Exception {
        // used for Neo4j browser
        try {
            WrappingNeoServerBootstrapper neoServerBootstrapper;
            GraphDatabaseAPI api = (GraphDatabaseAPI) db;

            ServerConfigurator config = new ServerConfigurator(api);
            config.configuration()
                    .addProperty(Configurator.WEBSERVER_ADDRESS_PROPERTY_KEY, "127.0.   0.1");
            config.configuration()
                    .addProperty(Configurator.WEBSERVER_PORT_PROPERTY_KEY, "8686");

            neoServerBootstrapper = new WrappingNeoServerBootstrapper(api, config);
            neoServerBootstrapper.start();
        } catch(Exception e) {
            //handle appropriately
        }
        // end of Neo4j browser config
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }


}