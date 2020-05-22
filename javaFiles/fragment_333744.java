import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.apache.logging.log4j.web.Log4jServletContainerInitializer;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;

public class WebInitialiser extends Log4jServletContainerInitializer implements WebApplicationInitializer {

    public void onStartup(ServletContext servletContext)
            throws ServletException {

        super.onStartup(null, servletContext);

        AnnotationConfigWebApplicationContext rootContext = new AnnotationConfigWebApplicationContext();

        rootContext.register(ApplicationConfig.class, IntegrationConfig.class,
                JmsConfig.class, JmxConfig.class);

        servletContext.addListener(new ContextLoaderListener(rootContext));
    }

}