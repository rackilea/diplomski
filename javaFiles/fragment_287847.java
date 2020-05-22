<bean id="dataSource" class="com.jolbox.bonecp.BoneCPDataSource" destroy-method="close">
    <property name="driverClass" value="${jdbc.driverClassName}"/>
    <property name="jdbcUrl" value="${jdbc.url}"/>
    <property name="username" value="${jdbc.username}"/>
    <property name="password" value="${jdbc.password}"/>
    <property name="idleConnectionTestPeriod" value="60"/>
    <property name="idleMaxAge" value="240"/>
    <property name="maxConnectionsPerPartition" value="30"/>
    <property name="minConnectionsPerPartition" value="10"/>
    <property name="partitionCount" value="3"/>
    <property name="acquireIncrement" value="5"/>
    <property name="statementsCacheSize" value="100"/>
    <property name="releaseHelperThreads" value="3"/>
</bean>