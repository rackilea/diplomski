<bean id="dataSource" class="com.mchange.v2.c3p0.ComboPooledDataSource" destroy-method="close">
<property name="driverClass">
    <value>${IP}</value>
</property>
<property name="jdbcUrl">
    <value>IP</value>
</property>
<property name="user">
    <value>${user}</value>
</property>
<property name="password">
    <value>${password}</value>
</property>