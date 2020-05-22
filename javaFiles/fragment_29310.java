package jersey.servlet.initializer;

import com.sun.jersey.spi.container.servlet.ServletContainer;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import javax.servlet.ServletContainerInitializer;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

public class MyJerseyContainerInitializer implements ServletContainerInitializer{

    @Override
    public void onStartup(Set<Class<?>> set, ServletContext sc) 
                                                    throws ServletException {
        System.out.println("===============================================");
        System.out.println("                 onStartup()                   ");
        System.out.println("===============================================");
        Map<String, String> map = new HashMap<>();
        map.put("com.sun.jersey.config.property.packages", 
                   "jersey.servlet.initializer.rest");

        ServletRegistration.Dynamic dispatcher = sc.addServlet(
                "restful", new ServletContainer());
        dispatcher.setInitParameters(map);
        dispatcher.setLoadOnStartup(1);
        dispatcher.addMapping("/rest/*");
    }
}