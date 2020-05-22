<!-- Employee DB data source. -->
<bean id="employeeDataSource" class="com.mchange.v2.c3p0.ComboPooledDataSource"
    destroy-method="close">
    <property name="driverClass" value="${jdbc.driverClassName}" />
    <property name="jdbcUrl" value="${jdbc.employee_db_url}" />
    <property name="user" value="${jdbc.username}" />
    <property name="password" value="${jdbc.password}" />
    <property name="maxPoolSize" value="${jdbc.maxPoolSize}" />
    <property name="minPoolSize" value="${jdbc.minPoolSize}" />
    <property name="maxStatements" value="${jdbc.maxStatements}" />
    <property name="testConnectionOnCheckout" value="${jdbc.testConnection}" />
</bean>