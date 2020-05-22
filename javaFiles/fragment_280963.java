<bean id="hikariConfig" class="com.zaxxer.hikari.HikariConfig">
   <property name="jdbcUrl"
             value="jdbc:sybase:Tds:${hostname}:${port}/${dbname}" />
   <property name="connectionTestQuery" value="SELECT 1" />
   <property name="maximumPoolSize" value="100" />
   <property name="idleTimeout" value="60000" />
   <property name="username" value="${username}" />
   <property name="password" value="${password}" />
</bean>