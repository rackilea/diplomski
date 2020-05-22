If you are using 3rd party jars for connection polling then you can enable their logging and set logAbandoned property to true. So it will log your all logAbandoned connections.

As shown below - 
<bean id="dataSource" class="org.apache.tomcat.jdbc.pool.DataSource" destroy-method="close">
        <property name="driverClassName" value="${dataSource.driverClassName}" />
        <property name="url" value="${dataSource.url}" />
        <property name="username" value="${dataSource.username}" />
        <property name="password" value="${dataSource.password}" />
        <property name="validationQuery" value="${datasource.validationQuery}" />
        <property name="maxActive" value="${datasource.maxActive}" />
        <property name="maxIdle" value="${datasource.maxIdle}" />
        <property name="maxWait" value="${datasource.maxWait}" />
        <property name="testOnBorrow" value="true" />
        <property name="testWhileIdle" value="true" />      
        <property name="minIdle" value="${datasource.minIdle}" />
        <property name="initialSize" value="${datasource.initialSize}" />
        <property name="timeBetweenEvictionRunsMillis" value="${datasource.timeBetweenEvictionRunsMillis}" />
        <property name="logAbandoned" value="${datasource.logAbandoned}" />
    </bean>