<bean id="dataSource"
        class="org.springframework.jdbc.datasource.SingleConnectionDataSource">
        <property name="driverClassName" value="${jdbc.driver}" />
        <property name="username" value="${jdbc.user}" />
        <property name="password" value="${jdbc.pass}" />
        <property name="url" value="${jdbc.url}" />
        <property name="suppressClose" value="true" />
    </bean>