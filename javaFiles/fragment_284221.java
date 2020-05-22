import java.util.Hashtable;
import javax.naming.AuthenticationException;
import javax.naming.Context;
import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;
import javax.naming.directory.SearchControls;
import javax.naming.directory.SearchResult;

public class SimpleLdapAuthentication {

    public String ldapquery() {
        String distName = "";
        String username = "cn=demo,ou=People,dc=saas,dc=com";
        String[] userID = new String[2];
        userID[0] = "Users";
        userID[1] = "Developers";
        int size = userID.length;
        String password = "sacs3";
        String groupName = "";
        String base = "ou=People,dc=maxcrc,dc=com";
        //String searchFilter = "cn=" + username + "," + base;
        String ldapURL = "ldap://yourldapurl";
        Hashtable<String, String> environment = new Hashtable<String, String>();
        environment.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
        environment.put(Context.PROVIDER_URL, ldapURL);
        environment.put(Context.SECURITY_AUTHENTICATION, "simple");
        environment.put(Context.SECURITY_PRINCIPAL, username);
        environment.put(Context.SECURITY_CREDENTIALS, password);
        String[] returnAttribute = {"member"};
        SearchControls srchControls = new SearchControls();
        srchControls.setReturningAttributes(returnAttribute);
        srchControls.setSearchScope(SearchControls.SUBTREE_SCOPE);
        for (int i = 0; i <= size - 1; i++) {
            String searchFilter = "(cn=" + userID[i] + ")";
            try {
                DirContext authContext = new InitialDirContext(environment);
                //System.out.println("Authentication Successful");
                NamingEnumeration<SearchResult> search = authContext.search(base, searchFilter, srchControls);
                // Probably want to test for nulls here
                distName = search.nextElement().toString();

                String[] splitBasedOnColon = distName.split("\\:");
                for (String x : splitBasedOnColon) {
                    if (x.startsWith("cn")) {
                        String[] splitGroupName = x.split("\\=");
                        groupName = splitGroupName[1];
                    }
                }
                if (distName.contains(username)) {
                    System.out.println("User is part of the group: " + groupName);
                }
            } catch (AuthenticationException authEx) {
                System.out.println("Authentication failed!");
            } catch (NamingException namEx) {
                System.out.println("Something went wrong!");
                namEx.printStackTrace();
            } catch (NullPointerException notFound) {
                System.out.println("User is not part group : "+ userID[i]);
               // notFound.printStackTrace();
            }
        }
        return distName;
    }
}