import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

   @WebListener
    public class Initializer implements ServletContextListener {

    @Override
    public final void contextInitialized(final ServletContextEvent sce) {
            SMTPServer smtp_server = SMTPServer.getInstance();
            smtp_server.start();
}
}