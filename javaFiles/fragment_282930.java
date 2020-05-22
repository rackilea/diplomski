DirContext ctx = new InitialLdapContext( env, null );

SearchControls searchControls = new SearchControls();
searchControls.setSearchScope( SearchControls.OBJECT_SCOPE );
searchControls.setReturningAttributes( new String[]
    { "objectClasses" } );
NamingEnumeration<SearchResult> results = ctx.search( "cn=schema", "(ObjectClass=*)", searchControls );

SearchResult result = results.next();
Attributes entry = result.getAttributes();

Attribute objectClasses = entry.get( "objectClasses" );
System.out.println( objectClasses );