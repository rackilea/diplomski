<bean id="serviceFacade" class="ServiceFacade">
    <property name="endpoint" value="${env.endpoint}"/>
</bean>

<bean class="org.springframework.beans.factory.config.PropertyPlaceholderConfigurer">
    <property name="locations">
        <value>classpath:environment.properties</value>
    </property>
</bean>