<ldap-authentication-provider
    user-search-filter="(cn={0})" 
    user-search-base="dc=example,dc=com"
    group-search-filter="(member={0})"
    group-search-base="dc=example,dc=com"
    group-role-attribute="cn" 
    role-prefix="ROLE_"
    user-context-mapper-ref="userContextMapper">