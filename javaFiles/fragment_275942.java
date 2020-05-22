<ldap-user-service id="userService" 
    server-ref="yourLdapServer" 
    user-search-base="ou=people"
    user-search-filter="(uid={0})"
    group-search-base="ou=groups"
    group-role-attribute="cn"
    group-search-filter="(member={0})"
    role-prefix="ROLE_" />