<!-- here you have a configurer based on a *.properties file -->
<bean id="configurer" 
      class="org.springframework.beans.factory.config.PropertyPlaceholderConfigurer">
    <property name="location" value="file://${configDir}/configuration.properties"/>
    <property name="ignoreResourceNotFound" value="false" />
    <property name="ignoreUnresolvablePlaceholders" value="false" />
    <property name="searchSystemEnvironment" value="false" />
</bean>

<!-- this is how you can use configuration properties -->
<bean id="mailSender" class="org.springframework.mail.javamail.JavaMailSenderImpl">
    <property name="host" value="${smtp.host}"/>
</bean>