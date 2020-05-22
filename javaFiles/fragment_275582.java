package vijay.configuration;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * PropertyApplicationContext Class to load Property Configuration XML.
 * @author Vijay
 */
public class PropertyApplicationContext implements ApplicationContextAware{

    private ApplicationContext applicationContext;

    private static PropertyApplicationContext propertyApplicationContext;

    private PropertyApplicationContext(){
        applicationContext = new ClassPathXmlApplicationContext("property-config.xml");
    }

    @Override
    public void setApplicationContext(ApplicationContext ac) throws BeansException {
        if(applicationContext == null){
            this.applicationContext = ac;
        }
    }

    public ApplicationContext getApplicationContext(){
        return applicationContext;
    }

    public static PropertyApplicationContext getInstance(){
        if(propertyApplicationContext == null){
            propertyApplicationContext = new PropertyApplicationContext();
        }
        return propertyApplicationContext;
    }

}