<bean id="sqlServerDataSource"
      class="com.microsoft.sqlserver.jdbc.SQLServerConnectionPoolDataSource">
    <property name="URL" value="jdbc:sqlserver://${database.server};databaseName=${database.databaseName};"/>
    <property name="user" value="#{DatabaseSetup.username}" />
    <property name="password" value="#{DatabaseSetup.password}" />
</bean>