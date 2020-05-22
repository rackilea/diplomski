@Configuration
@Import(value = { PropertiesConfig.class, AppConfig.class })
@ComponentScan( basePackages = "a.b", 
                excludeFilters = {
                    @ComponentScan.Filter(type = FilterType.ANNOTATION, value = RestController.class), 
                    @ComponentScan.Filter(type = FilterType.ANNOTATION, value = Configuration.class})
public class RootConfig {}