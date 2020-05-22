public void setNamePassword(){
        //some code
        PropertyPlaceholderConfigurer configurer = new PropertyPlaceholderConfigurer();
        Properties properties = new Properties();
        properties.setProperty("property.userName", "username");
        properties.setProperty("property.password", "password");
        configurer.setProperties(properties);
                       //Include below line if you have another 
                       //PropertyPlaceholderConfigurer in springConfigXml2.xml       
                        configurer.setIgnoreUnresolvablePlaceholders(true); 
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext();
        context.addBeanFactoryPostProcessor(configurer);
        context.setConfigLocation("springConfigXml2.xml");
        context.refresh();
        //some code
    }



    springConfigXml2.xml
    <?xml version="1.0" encoding="UTF-8"?>
    <beans xmlns="http://www.springframework.org/schema/beans"
           xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
           xsi:schemaLocation="
    http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans-2.5.xsd">
        <bean id="asyncListener" class="com.example.AsyncListenerClass">
            <property name="userName" value="${property.userName}"/>
            <property name="password" value="${property.password}"/>
        </bean>
    </beans>