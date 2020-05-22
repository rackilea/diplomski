<beans:bean id="ldapActiveDirectoryAuthProvider" class="com.graybar.pima.security.ActiveDirectoryLdapAuthenticationProvider">
    <beans:constructor-arg value="${ldap.domain}" />
    <beans:constructor-arg value="${ldap.url}" />
    <beans:property name="authoritiesMapper" ref="grantedAuthoritiesMapper" />
    <beans:property name="useAuthenticationRequestCredentials" value="true" />
    <beans:property name="convertSubErrorCodesToExceptions" value="true" />
</beans:bean>