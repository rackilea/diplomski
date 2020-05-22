<!-- Create a datasource -->
<bean id="dataSource" class="org.springframework.jdbc.datasource.DriverManagerDataSource">

    <property name="driverClassName" value="${driver}" />
    <property name="url" value="${url}" />
    <property name="username" value="${username}" />
    <property name="password" value="${password}" />

</bean>

<!-- Create an Hibernate to Jpa adapter -->
<bean id="jpaVendorAdapter" class="org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter">

    <property name="generateDdl" value="true" />
    <property name="showSql" value="false" />
    <property name="database" value="MYSQL" />

</bean>

<!-- persistenceUnitManager is optional -->
<bean id="persistenceUnitManager" class="org.springframework.orm.jpa.persistenceunit.DefaultPersistenceUnitManager">

    <property name="defaultDataSource" ref="dataSource"/>

</bean>

<!-- create entityManagerFactory -->
<bean id="entityManagerFactory" class="org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean">

    <property name="persistenceUnitManager" ref="persistenceUnitManager"/>
    <property name="jpaVendorAdapter" ref="jpaVendorAdapter" />

    <property name="jpaProperties">
        <props>
            <prop key="hibernate.temp.use_jdbc_metadata_defaults">false</prop>
            <prop key="hibernate.dialect">org.hibernate.dialect.MySQLDialect</prop>
        </props>
    </property>

</bean>

<!-- and create transactionManager -->
<bean id="transactionManager" class="org.springframework.orm.jpa.JpaTransactionManager">
    <property name="entityManagerFactory" ref="entityManagerFactory"/>
</bean>