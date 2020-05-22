import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Singleton;
import javax.ejb.Startup;

@Singleton
@Startup
public class WorkerServletStopper {

    @PreDestroy
    public void preDestroy(){
        WorkerServlet.forceStop();
    }
}