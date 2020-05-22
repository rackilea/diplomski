<bean id="dataSource"
        class="org.springframework.jdbc.datasource.DriverManagerDataSource">
        <property name="driverClassName" value="${DbDriverName}" />
        <property name="url" value="${DbUrl}" />
        <property name="username" value="${DbUsername}" />
        <property name="password" value="${DbPassword}" />
    </bean>