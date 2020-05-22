<bean id="dataSource" class="org.springframework.jdbc.datasource.DriverManagerDataSource">
    <property name="driverClassName" value="${database.driver}" />
    <property name="url" value="${database.url}" />
    <property name="username" value="${database.user}" />
    <property name="password" value="${database.password}" />
</bean>