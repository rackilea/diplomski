@Import(MyAutoConfig.class)
@SpringBootApplication
public class MinStarterBasicApp {

@Bean
ServiceRegistry serviceRegistry() {
    return mock(ServiceRegistry.class);
    }

    static ConfigurableApplicationContext setupWebApp(String... profiles){
        System.setProperty("spring.main.allow-bean-definition-overriding", "true");

        SpringApplication app = new SpringApplicationBuilder(MinStarterBasicApp.class)
                .web(WebApplicationType.SERVLET)
                .profiles(profiles)
                .build();
        return app.run();
    }
}