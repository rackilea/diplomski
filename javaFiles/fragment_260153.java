public class searchattribute {
public static void main(String[] args) {

    Hashtable env = new Hashtable();
    String adminName = "cn=admin,o=novell";
    String adminPassword = "Happiest1";
    String ldapURL = "ldaps://10.18.26.192:636";

    // Access the keystore, this is where the Root CA public key cert was
    // installed
    // Could also do this via the command line option java
    // -Djavax.net.ssl.trustStore....
    // No need to specifiy the keystore password for read operations
    String keystore = "C:\\Users\\durga.tiruvakkad\\Desktop\\cert.keystore";
    System.setProperty("javax.net.ssl.trustStore", keystore);

    env.put(Context.INITIAL_CONTEXT_FACTORY,
            "com.sun.jndi.ldap.LdapCtxFactory");

    // set security credentials
    env.put(Context.SECURITY_AUTHENTICATION, "simple");
    env.put(Context.SECURITY_PRINCIPAL, adminName);
    env.put(Context.SECURITY_CREDENTIALS, adminPassword);

    // specify use of ssl
    env.put(Context.SECURITY_PROTOCOL, "ssl");

    // connect to my domain controller
    env.put(Context.PROVIDER_URL, ldapURL);
    try {

        // Create the initial directory context
        DirContext ctx = new InitialLdapContext(env, null);

        Attribute attr = ctx.getAttributes("sn").get("UID");
        String uid = (String) attr.get();

        // Create the search controls
        SearchControls searchCtls = new SearchControls();

        // Specify the attributes to return
        String returnedAtts[] = { "sn", "givenName", "UID" };
        searchCtls.setReturningAttributes(returnedAtts);

        // Specify the search scope
        searchCtls.setSearchScope(SearchControls.SUBTREE_SCOPE);

        // specify the LDAP search filter
        String searchFilter = "(&(objectClass=user)(UID=*))";

        // Specify the Base for the search
        String searchBase = "ou=FWCMS,o=novell";

        // initialize counter to total the results
        int totalResults = 0;

        // Search for objects using the filter
        NamingEnumeration answer = ctx.search(searchBase, searchFilter,
                searchCtls);

        // Loop through the search results
        while (answer.hasMoreElements()) {
            SearchResult sr = (SearchResult) answer.next();

            totalResults++;

            System.out.println(">>>" + sr.getName());

            // Print out some of the attributes, catch the exception if the
            // attributes have no values
            Attributes attrs = sr.getAttributes();
            if (attrs != null) {
                try {
                    int count = 0;
                    System.out.println("   surname: "
                            + attrs.get("sn").get());

                    String lastName = (String) attrs.get("sn").get();

                    System.out.println("   firstname: "
                            + attrs.get("givenName").get());

                    String firstName = (String) attrs.get("givenName")
                            .get();

                    if (attrs.get("UID").toString().contains("GIVENUID")) {
                        count++;
                        attrs.get("UID").get().toString()
                                .concat(firstName.substring(0, 3))
                                .concat(lastName.substring(0, 3))
                                .concat(String.valueOf(count));
                    }
                    System.out.println("   UID: " + attrs.get("UID").get());

                } catch (NullPointerException e) {
                    System.out.println("Errors listing attributes: " + e);
                }
            }

        }

        System.out.println("Total results: " + totalResults);
        ctx.close();

    } catch (NamingException e) {
        System.err.println("Problem searching directory: " + e);
    }
}