# Put in attribute-resolver.xml
<DataConnector id="myLDAP" xsi:type="LDAPDirectory"
    ldapURL="%{idp.attribute.resolver.LDAP.ldapURL}"
    baseDN="%{idp.attribute.resolver.LDAP.baseDN}"
    principal="%{idp.attribute.resolver.LDAP.bindDN}"
    principalCredential="%{idp.attribute.resolver.LDAP.bindDNCredential}"
    trustFile="%{idp.attribute.resolver.LDAP.trustCertificates}"
    useStartTLS="%{idp.attribute.resolver.LDAP.useStartTLS:true}"
    noResultIsError="%{idp.attribute.resolver.LDAP.noResultsIsError:false}"
    multipleResultsIsError="%{idp.attribute.resolver.LDAP.multipleResultsIsError:true}">
    <FilterTemplate>
        <![CDATA[
            %{idp.attribute.resolver.LDAP.searchFilter}
        ]]>
    </FilterTemplate>
    <LDAPProperty name="name1" value="%{idp.attribute.resolver.LDAP.prop1}"/>
    <LDAPProperty name="name2" value="%{idp.attribute.resolver.LDAP.prop2}"/>
    <StartTLSAuthenticationCredential xsi:type="security:X509Filesystem" xmlns:security="urn:mace:shibboleth:2.0:security" id="IdPtoLDAPCredential">
        <security:PrivateKey>%{idp.attribute.resolver.LDAP.authenticationKey}</security:PrivateKey>
        <security:Certificate>%{idp.attribute.resolver.LDAP.authenticationCertificate}</security:Certificate>
    </StartTLSAuthenticationCredential>
</DataConnector>