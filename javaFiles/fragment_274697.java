<bean id="dataSource" class="com.zaxxer.hikari.HikariDataSource">
  <constructor-arg>
    <bean class="com.zaxxer.hikari.HikariConfig">
      <property name="dataSource">
        <bean class="org.hsqldb.jdbc.JDBCDataSource">
          <property name="url" value="${database.database.jdbc.url}"/>
          <property name="databaseName" value="${database.name}"/>
          <property name="user" value="${database.user}"/>
          <property name="password" value="${database.password}"/>
        </bean>
      </property>
    </bean>
  </constructor-arg>
</bean>