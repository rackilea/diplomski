import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfiguration {

    @Bean
    public DemoManager helloWorld()
    {
        return new DemoManagerImpl();
    }
}