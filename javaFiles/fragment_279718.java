@Configuration
@Import(DispatcherServletConfig.class)
@ComponentScan(basePackages = "org.parkingTracker.controller, org.parkingTracker.service, org.parkingTracker.dao")
@ImportResource("classpath:dao-context.xml")
public class RootConfig {
    public RootConfig() {}
}