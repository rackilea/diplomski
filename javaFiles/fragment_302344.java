@SpringBootApplication
@ComponentScan(basePackages = {
        "com.abc.pkg1",
        "com.abc.pk2"},
        excludeFilters = {
                @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, 
                value = SolrConfiguration.class)})
public class TestApplication {
    public static void main(String[] args) throws Exception {
        SpringApplication.run(TestApplication.class, args);
    }
}