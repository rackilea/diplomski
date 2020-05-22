<bean id="propertyConfigurer"
class="org.springframework.beans.factory.config.PropertyPlaceholderConfigurer"
p:location="{location of hibernate properties files}" />

<bean id="dataSource" class="com.mchange.v2.c3p0.ComboPooledDataSource">
    <property name="driverClass" value="${db.driverClassName}"/>
    <property name="jdbcUrl" value="${db.databaseurl}"/>
    ....other properties...
</bean>