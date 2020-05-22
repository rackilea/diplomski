@Configuration
@ComponentScan(excludeFilters = @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, classes = {
        ComponentScanTest.ExcludedConfig.class }))
public class TestConfiguration {

}