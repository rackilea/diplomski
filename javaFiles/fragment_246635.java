@SpringBootApplication
@EntityScan(basePackages = {"EntityPackage"} )
@EnableJpaRepositories(basePackages = {"RepositoryPackage"})
public class Application {

    public static void main(String[] args) {

        SpringApplication.run(Application.class, args);

    }
}