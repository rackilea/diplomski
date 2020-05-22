import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean(name="HelloImpl1")
    public HelloImpl1 helloImpl1() {
        return new HelloImpl1();
    }

    @Bean(name="HelloImpl2")
    public HelloImpl1 helloImpl2() {
        return new HelloImpl2();
    }
}