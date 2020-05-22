@SpringBootApplication
@ComponentScan(basePackages = "my.base.package",
        excludeFilters = @ComponentScan.Filter(type = FilterType.REGEX, pattern = "my.base.package.repositories.*.*"))
public class TestApplication {

    public static void main(String[] args) {
        SpringApplication.run(TestApplication.class, args);
    }

    @Bean
    public Repository someFakeRepository() {
        return new FakeRepository();
    }

}