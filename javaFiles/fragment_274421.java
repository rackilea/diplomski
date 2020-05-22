<bean id="dataSourceGlobal" class="com.mchange.v2.c3p0.ComboPooledDataSource"
          destroy-method="close">
        <property name="driverClass" value="${driver}" />
        <property name="jdbcUrl" value="${server}" />
        <property name="user" value="${user}" />
        <property name="password" value="${passw}" /> 

        <!-- these are C3P0 properties -->
        <property name="acquireIncrement" value="${acquireIncrement}" />
        <property name="minPoolSize" value="${minPoolSize}" />
        <property name="maxPoolSize" value="${maxPoolSize}" />
        <property name="maxIdleTime" value="${maxIdleTime}" />
</bean>