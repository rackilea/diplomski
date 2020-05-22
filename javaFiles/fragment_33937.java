<bean id="dataSource" class="org.apache.commons.dbcp.BasicDataSource">
<property name="driverClassName" value="${driverClassName}" />
<property name="url" value="${datasource.url}" />
<property name="username" value="#" />
<property name="password" value="#" />
<property name="connectionInitSqls" value="${datasource.initsql}" />
</bean>