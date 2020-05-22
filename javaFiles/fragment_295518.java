import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class Daemons implements ServletContextListener {
private volatile boolean active = true;

Runnable myDeamon = new Runnable() {

    public void run() {
        while (active) {
            try {
                System.out.println("checking changed files...");
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
};

public void contextInitialized(ServletContextEvent servletContextEvent) {
    new Thread(myDeamon).start();
}

public void contextDestroyed(ServletContextEvent servletContextEvent) {
    active = false;
}
}