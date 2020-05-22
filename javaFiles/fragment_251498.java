package testingThings.properties;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Properties;  
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class ContextListener implements ServletContextListener {
    public ContextListener() {}
    public void contextDestroyed(ServletContextEvent sce) {}

    public void contextInitialized(ServletContextEvent sce) {
        InputStream stream = Thread.currentThread().getContextClassLoader()
                .getResourceAsStream("testingThings/properties/system.properties");
        Properties props = new Properties();

        try {
            props.load(stream);
        } catch (IOException e) {
            e.printStackTrace();
        }

        HashMap<String, String> map = new HashMap<String, String>();

        for (final String name : props.stringPropertyNames()) {
            map.put(name, props.getProperty(name));
        }

        sce.getServletContext().setAttribute("system", map);
    }
}