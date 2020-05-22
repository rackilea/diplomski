@Configuration("testConfig")
@ImportResource({
    "dataSources-config.xml",
    "dao-config.xml",
    "services-config.xml"
})
public class TestConfiguration {

    // TO create a spring managed bean
    @Bean
    MyBean myBean() {
        return new MyBean();
    }

}