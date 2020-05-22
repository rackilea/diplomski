@Configuration
@ComponentScan("com.example")
@EnableMongoRepositories(basePackages = "com.example.domain.repositories.mongodb")
@EnableNeo4jRepositories(basePackages = "com.example.domain.repositories.neo4j")
@SpringBootApplication
public class TestConfig {
}