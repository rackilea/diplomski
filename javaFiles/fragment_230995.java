<bean id="contextSource" class="org.springframework.ldap.core.support.LdapContextSource">
    <property name="url" value="${ldap.url}" />
    <property name="base" value="${ldap.base}" />
    <property name="userDn" value="${ldap.userdn}" />
    <property name="password" value="${ldap.password}" />
</bean>

<bean id="ldapTemplate" class="org.springframework.ldap.core.LdapTemplate">
    <constructor-arg ref="contextSource" />
</bean>