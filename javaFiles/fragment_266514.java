import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;

@Startup
@Singleton
public class QuartzTimerBean{
    @PostConstruct
    public void init() {
            ...
            // Start Quartz timer here
            ...
    }

    @PreDestroy
    public void cleanup(){
            ...
            // Clean up Quartz timer
            ...
    }
}