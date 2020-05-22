SearchControls constraints = new SearchControls();
constraints.setSearchScope(SearchControls.SUBTREE_SCOPE);

String[] attrIDs = { "CommonNames","firstname","givenName","uid","email"};
constraints.setReturningAttributes(attrIDs);

NamingEnumeration answer = ctx.search("", "uid="+user, constraints);
if (answer.hasMore()) {

Attributes attrs = ((SearchResult) answer.next()).getAttributes();
CommonNames= (attrs.get("CommonNames").toString());
System.out.println(CommonNames);


}