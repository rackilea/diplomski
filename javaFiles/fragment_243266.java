import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class StartupExec implements {

  @EventListener(ContextRefreshedEvent.class)
  public void contextRefreshedEvent() {
    // do whatever you need here 
  }
}