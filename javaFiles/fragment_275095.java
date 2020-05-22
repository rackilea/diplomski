import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Startup;
import javax.ejb.Singleton;

@Singleton
@Startup
public class InitializerEjb {

  @PostConstruct
  public void init() {
    SMTPServer smtp_server = SMTPServer.getInstance();
    smtp_server.start();
  }   
}