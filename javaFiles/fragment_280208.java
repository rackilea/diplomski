<!-- Step 1: Define Database DataSource / connection pool -->
<bean id="myDataSource" class="com.mchange.v2.c3p0.ComboPooledDataSource"
      destroy-method="close">
    <property name="driverClass" value="${get.driverClass}" />
    <property name="jdbcUrl" value="${get.jdbcUrl}" />
    <!--  
          This option allow the Hibernate create database on startup.
          <property name="jdbcUrl" value="jdbc:mysql://localhost:3306/java_arabic_community?createDatabaseIfNotExist=true&amp;
          useUnicode=yes&amp;characterEncoding=utf8" /> 
    -->
    <property name="user" value="${get.user}" />
    <property name="password" value="${get.password}" /> 

    <!-- these are connection pool properties for C3P0 -->
    <property name="minPoolSize" value="3" />
    <property name="maxPoolSize" value="20" />
    <property name="maxIdleTime" value="30000" />
</bean>  

<!-- Step 2: Setup Hibernate session factory -->
<bean id="sessionFactory"
    class="org.springframework.orm.hibernate5.LocalSessionFactoryBean">
    <property name="dataSource" ref="myDataSource" />
    <property name="packagesToScan" value="com.community.web" />
    <property name="hibernateProperties">
       <props>
          <prop key="hibernate.dialect">org.hibernate.dialect.MySQLDialect</prop>
          <!--  
            This option allow the Hibernate create tables on startup and destroy previous data
             <prop key="hibernate.hbm2ddl.auto">update</prop> 
          -->
          <prop key="hibernate.connection.CharSet">utf8</prop>
          <prop key="hibernate.connection.characterEncoding">utf8</prop>
          <prop key="hibernate.connection.useUnicode">true</prop>
          <prop key="hibernate.show_sql">true</prop>
       </props>
    </property>