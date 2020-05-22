@Configuration
public class TestConfig {


@Autowired
private Filter springSecurityFilterChain;

@Autowired
private WebApplicationContext webApplicationContext;

@Bean
public MockMvc mockMvc() {
    return MockMvcBuilders
            .webAppContextSetup(webApplicationContext)
            .apply(springSecurityFilterChain)
            .build();
}
}