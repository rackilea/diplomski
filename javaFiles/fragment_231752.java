<bean id="bonecpDs" class="com.jolbox.bonecp.BoneCPDataSource"
    lazy-init="true" destroy-method="close">
    <property name="driverClass" value="${jdbc.driverclassname}" />
    <property name="jdbcUrl" value="${jdbc.connection.url}" />
    <property name="username" value="${jdbc.username}" />
    <property name="password" value="${jdbc.password}" />
    <property name="idleConnectionTestPeriodInMinutes" value="${db.idleconnectiontestperiod}" />
    <property name="idleMaxAgeInMinutes" value="${db.idlemaxage}" />
    <property name="maxConnectionsPerPartition" value="${db.poolsize}" />
    <property name="minConnectionsPerPartition" value="${db.minpoolsize}" />
    <property name="partitionCount" value="${db.numpools}" />
    <property name="acquireIncrement" value="${db.acquireincrement}" />
    <property name="releaseHelperThreads" value="${db.releasehelperthreads}" />
    <property name="statementReleaseHelperThreads" value="${db.statementreleasehelperthreads}" />
    <property name="disableConnectionTracking" value="${db.disableconnectiontracking}" />
    <property name="closeConnectionWatch" value="${db.closedconnnectionwatch}" />
    <property name="connectionTimeoutInMs" value="${db.connectiontimeout}" />
    <property name="connectionTestStatement" value="select now()" />
    <property name="lazyInit" value="true"/>
</bean>