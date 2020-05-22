<bean id="example" class="com.mycom.factory.JpaVendorAdapterFactory">
   <property name="class" value="${jpa.vendor.adapter}"/>
   <property name="showSql" value="true" />
   <property name="generateDdl" value="true" />
   <property name="databasePlatform" value="org.hibernate.dialect.OracleDialect" />
</bean>