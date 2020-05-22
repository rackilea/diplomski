LdapContextSource ctxSrc = new LdapContextSource();
    ctxSrc.setUrl("ldap://<url>");
    ctxSrc.setBase("dc=example,dc=local");
    ctxSrc.setUserDn("<user>@example.local");
    ctxSrc.setPassword("<pass>");

ctxSrc.afterPropertiesSet(); // this method should be called.

LdapTemplate tmpl = new LdapTemplate(ctxSrc);
setLdapTemplate(tmpl);