jersey 1:

import java.util.Map;

import javax.annotation.PostConstruct;
import javax.ws.rs.Path;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import com.sun.jersey.api.core.DefaultResourceConfig;

@Component
public class RestApplication extends DefaultResourceConfig {

    private static final Logger log = LoggerFactory.getLogger(RestApplication.class);

    public RestApplication() {
        getFeatures().put("com.sun.jersey.api.json.POJOMappingFeature", true);
    }

    @Autowired
    ApplicationContext appCtx;

    @PostConstruct
    public void setup() {
        log.info("Rest classes found:");
        Map<String,Object> beans = appCtx.getBeansWithAnnotation(Path.class);
        for (Object o : beans.values()) {
            log.info(" -> " + o.getClass().getName());
            getSingletons().add(o);
        }
    }

}
and

    @Autowired
    RestApplication restApplication;

    @Bean
    public ServletRegistrationBean jersey() {
        ServletRegistrationBean bean = new ServletRegistrationBean();
        bean.setServlet(new ServletContainer(restApplication));
        bean.addInitParameter("com.sun.jersey.api.json.POJOMappingFeature", "true");
        bean.setUrlMappings(Arrays.asList("/rest/*"));
        return bean;
    }
jersery2:

import java.util.Map;

import javax.annotation.PostConstruct;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.Path;

import org.glassfish.jersey.server.ResourceConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import com.sun.jersey.api.core.ResourceConfig;

@Component
@ApplicationPath("/rest")
public class JerseyConfig extends ResourceConfig {

    private static final Logger log = LoggerFactory.getLogger(JerseyConfig.class);

    @Autowired
    ApplicationContext appCtx;

    @PostConstruct
    public void setup() {
        log.info("Rest classes found:");
        Map<String,Object> beans = appCtx.getBeansWithAnnotation(Path.class);
        for (Object o : beans.values()) {
            log.info(" -> " + o.getClass().getName());
            register(o);
        }
    }

}