LdapTemplate template = new LdapTemplate(ldapContextSource);
    template.setIgnorePartialResultException(true);
    String returnedAtts[] = { "configurationNamingContext" };
    SearchControls controls = new SearchControls(SearchControls.OBJECT_SCOPE,0,0,returnedAtts,false,false);

    LikeFilter  filter = new LikeFilter ("objectClass", "*");
    List<String> result = template.search("", filter.encode(), controls, new AttributesMapper<String>() {
        public String mapFromAttributes(Attributes attrs)
                throws NamingException {
                return attrs.get("configurationNamingContext").get().toString();
             }
          });