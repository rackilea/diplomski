NamingEnumeration<SearchResult> results = 
        dirContext.search("cn=Loggers,cn=config", "(objectClass=*)", searchCtls);

while (results.hasMore()) {
    SearchResult result = results.next();
    Attributes attributes = result.getAttributes();
    Attribute cn = attributes.get("cn");
    //get/iterate the values of the attribute
}