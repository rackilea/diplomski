@SpringBootApplication
@PropertySource(value = {"core-application.properties", "application.properties"})
@ComponentScan({"project.core", "project.graphql"})
@EnableJpaRepositories("project.core")
@EntityScan("project.core")
@EnableTransactionManagement
public class ProjectGraphQL {
    public static void main(String[] args) throws Exception {
        SpringApplication.run(ProjectGraphQL.class, args);
    }
}