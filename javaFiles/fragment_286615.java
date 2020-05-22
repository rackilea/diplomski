@Configuration
@ImportResource({"classpath:SpringBeans.xml"})
@ComponentScan(basePackages = "com.test.config")
public class AppConfig {

    @Bean
    public A a() {
        return new A();
    }

}