import java.util.Hashtable;
import javax.naming.Context;
import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.naming.directory.*;
import javax.naming.ldap.*;

public class UserFetch {
    public static void main(String[] args) {
        try{
            // Activate paged results
            byte[] cookie = null;
            int count=0;
            int total;

            Hashtable env = new Hashtable();

            env.put(Context.INITIAL_CONTEXT_FACTORY, 
            "com.sun.jndi.ldap.LdapCtxFactory");
            env.put(Context.REFERRAL, "follow");
            env.put(Context.SECURITY_AUTHENTICATION, "Simple");
            env.put(Context.SECURITY_PRINCIPAL, "USERNAME@DOM.COM");
            env.put(Context.SECURITY_CREDENTIALS, "PASSWORD");
            env.put(Context.PROVIDER_URL, "ldap://DOM.COM:389");
            LdapContext ctx = new InitialLdapContext(env, null);

            ctx.setRequestControls(new Control[]{ 
                new PagedResultsControl(10000, Control.CRITICAL) });

            do {
                // Perform the search
                NamingEnumeration results =
                ctx.search("dc=DOM,dc=COM", "(&(objectclass=user)(employeeNumber=*))", getSimpleSearchControls());

                // Iterate over a batch of search results
                while (results != null && results.hasMore()) {
                    // Display an entry
                    SearchResult entry = (SearchResult)results.next();
                    Attributes attrs = entry.getAttributes ();
                    System.out.println(attrs.get("SAMAccountName")); // Username
                    System.out.println("Firstname: " + 
                    attrs.get("givenname")); // firstname
                    System.out.println("Lastname: " + attrs.get("sn")); // lastname
                    System.out.println("EmployeeID " + attrs.get("employeeID"));
                    System.out.println("EmployeeNumber: " + 
                    attrs.get("employeeNumber"));
                    // Handle the entry's response controls (if any)
                }
                // Examine the paged results control response 
                Control[] controls = ctx.getResponseControls();
                if (controls != null) {
                    for (int i = 0; i < controls.length; i++) {
                        if (controls[i] instanceof PagedResultsResponseControl) {
                            PagedResultsResponseControl prrc =
                            (PagedResultsResponseControl)controls[i];
                            total = prrc.getResultSize();
                            cookie = prrc.getCookie();
                        } else {
                            // Handle other response controls (if any)
                        }
                    }
                }

                // Re-activate paged results
                ctx.setRequestControls(new Control[]{
                    new PagedResultsControl(10000, cookie, Control.CRITICAL) });
            } while (cookie != null);
        }  catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static SearchControls getSimpleSearchControls() {
        SearchControls searchControls = new SearchControls();
        searchControls.setSearchScope(SearchControls.SUBTREE_SCOPE);
        searchControls.setTimeLimit(30000);
        String[] attrIDs =
        { "SAMAccountName", "sn", "givenname", "employeeID", 
            "employeeNumber" };

        searchControls.setReturningAttributes(attrIDs);
        return searchControls;
    }


}