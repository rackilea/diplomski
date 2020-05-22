<bean id="dataSource" class="org.apache.tomcat.jdbc.pool.DataSource"
        destroy-method="close">
        <property name="driverClassName" value="${jdbc.driver}" />
        <property name="url" value="${jdbc.url}" />
        <property name="username" value="${jdbc.user}" />
        <property name="password" value="${jdbc.pass}" />
        <property name="initialSize" value="5" />
        <property name="maxActive" value="10" />
        <property name="maxIdle" value="5" />
        <property name="minIdle" value="2" />
</bean>