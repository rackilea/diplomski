<!-- LDAPS config -->
    <bean id="contextSourceTarget" class="com.yourpackage.SslLdap">
        <property name="url" value="${ldap.url}" />
        <property name="base" value="${ldap.base}" />
        <property name="userDn" value="${ldap.userDn}" />
        <property name="password" value="${ldap.password}" />
        <property name="pooled" value="false" />

    </bean>