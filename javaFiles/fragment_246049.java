import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

@Configuration
public class SomeConfig {
    @Autowired
    private ApplicationContext applicationContext;

    @PostConstruct
    public void init() {
        ApplicationContextHolder.INSTANCE.setApplicationContext(applicationContext);
    }
}