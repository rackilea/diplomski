ourApplication {
  org.ldaptive.jaas.LdapLoginModule required
    storePass="true"
    provider="org.ldaptive.provider.unboundid.UnboundIDProvider"
    ldapUrl="ldap://ldapserver:10389"
    baseDn="ou=People,dc=example,dc=com"
    useStartTLS="false"
    bindDn="uid=admin,ou=People,dc=example,dc=com"
    bindCredential="password"
    userFilter="(uid={user})";
  org.ldaptive.jaas.LdapRoleAuthorizationModule required
    useFirstPass="true"
    provider="org.ldaptive.provider.unboundid.UnboundIDProvider"
    ldapUrl="ldap://ldapserver:10389"
    baseDn="ou=Roles,dc=example,dc=com"
    roleFilter="(member={dn})"
    roleAttribute="cn";
};