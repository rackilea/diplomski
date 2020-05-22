import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import javax.annotation.PostConstruct;

@Named( "myBean" )
@ApplicationScoped
@Startup
@Singleton
public class MyBean {
    @PostConstruct
    public void postConstruct() {}
}