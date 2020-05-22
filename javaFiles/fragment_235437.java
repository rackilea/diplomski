<bean id="masterDBDatasource"
        class="org.springframework.jdbc.datasource.DriverManagerDataSource">
        <property name="driverClassName" value="${db.driver.class}" />
        <property name="url" value="${db.url}" />
        <property name="username" value="${db.username}" />
        <property name="password" value='#{T(com.xxxxxxx.CryptoUtil).decrypt("${encrypted.db.password}")}' /> 
</bean>