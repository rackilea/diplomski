import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.naming.directory.Attribute;
import javax.naming.directory.Attributes;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;
import javax.naming.ldap.*;
import javax.naming.directory.SearchControls;
import javax.naming.directory.SearchResult;
class GetAllAttrs 
{

  public static void main(String[] args) 
  {
    String filter = "cn=myuser";    // this is the user to look for
    String baseDN = "dc=my,dc=dom,dc=org";
    String ldapURL = "ldap://192.168.101.1:389";

    // Set up the environment for creating the initial context
    Hashtable<String, Object> env = new Hashtable<String, Object>(11);
    env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
    env.put(Context.PROVIDER_URL, ldapURL);

    try 
    {
      // Create the initial context
      LdapContext ctx = new InitialLdapContext(env, null);

      SearchControls sc = new SearchControls();
      sc.setSearchScope(SearchControls.SUBTREE_SCOPE);
      NamingEnumeration res = ctx.search (baseDN, filter, sc);

      while (res.hasMore()) 
      {
         SearchResult s = (SearchResult) res.next();

         // print user's DN
         System.out.println(">>" + s.getNameInNamespace());
      }

      // Close the context when we're done
      ctx.close();

    } 
    catch (Exception e) 
    {
      e.printStackTrace();
    }
  }
}