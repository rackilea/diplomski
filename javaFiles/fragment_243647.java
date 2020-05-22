<bean class="org.apache.commons.dbcp.BasicDataSource" destroy-method="close" id="dataSource">
        <property name="driverClassName" value="${database.driverClassName}"/>
        <property name="url" value="${database.url}"/>
        <property name="username" value="${database.username}"/>
        <property name="password" value="${database.password}"/>
        <property name="testOnBorrow" value="false"/>
        <property name="testOnReturn" value="false"/>
        <property name="testWhileIdle" value="false"/>
        <property name="timeBetweenEvictionRunsMillis" value="1800000"/>
        <property name="numTestsPerEvictionRun" value="3"/>
        <property name="maxActive" value="1" />

        <property name="minEvictableIdleTimeMillis" value="1800000"/>
    </bean>