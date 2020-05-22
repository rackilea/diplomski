import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationListener;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.event.ContextStartedEvent;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext = SpringApplication.run(DemoApplication.class, args);
        applicationContext.start();
    }

    @Component
    class ContextStartedListener implements ApplicationListener<ContextStartedEvent> {

        @Override
        public void onApplicationEvent(ContextStartedEvent event) {
            System.out.println("Context started");
        }
    }
}