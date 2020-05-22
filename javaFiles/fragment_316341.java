import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Hashtable;
import java.util.Enumeration;

import javax.naming.*;
import javax.naming.directory.*;
    public class LDAP_Reader_MultiUser1 {
    public static String INITCTX = "com.sun.jndi.ldap.LdapCtxFactory";
    public static String MY_HOST = "ldap://singh.local.com:3890";

    public static String MY_SEARCHBASE = "cn=Public,x=x-y,ou=people,cn=UserBase_8.0,cn=Application Services,x=x-y";

    public static String MY_FILTER = "(&(objectclass=groupOfUniqueNames)(uniqueMember=";
    public static String MGR_DN = "cn=Manager";
    public static String MGR_PW = "ldapadmin";

    public static void main(String[] args) throws IOException {
        String[] MY_FILTER2=new String[900];

    try{
        String fileName="C:\\report\\report.txt";
        FileReader inputFile = new FileReader(fileName);
        BufferedReader bufferReader = new BufferedReader(inputFile);
        String line;
        String only_name;
        int i=0;
        while ((line = bufferReader.readLine()) != null)
        {

            MY_FILTER2[i]=line;
            //System.out.println("My_Filter2="+MY_FILTER2[i]);
            i++;

        only_name="ram";

            //System.out.println("MAking my_filter_final");
        String MY_FILTER_Final=MY_FILTER+line+"))";



    Hashtable env = new Hashtable();
    env.put(Context.INITIAL_CONTEXT_FACTORY,INITCTX);
    env.put(Context.PROVIDER_URL,MY_HOST);
    env.put(Context.SECURITY_AUTHENTICATION,"simple");
    env.put(Context.SECURITY_PRINCIPAL,MGR_DN);
    env.put(Context.SECURITY_CREDENTIALS,MGR_PW);
    DirContext ctx = new InitialDirContext(env);
    SearchControls constraints = new SearchControls();
    constraints.setSearchScope(SearchControls.SUBTREE_SCOPE);
    //performs the actual search
    //We give it a searchbase, a filter and the contraints containing the scope
    //of the search
    NamingEnumeration results = ctx.search(MY_SEARCHBASE,MY_FILTER_Final,constraints);
    //now stop through the search results
    while(results==null)
    {
        System.out.println("**************************************"+line+"$$$$$does not exit in USerlist");
    }
    while(results != null && results.hasMore()){
    SearchResult sr = (SearchResult)results.next();
    String dn = sr.getName();
    String state = dn.substring(dn.indexOf("cn=")+3);
    System.out.println(line+"  Belongs to Group="+state);
    Attributes attrs = sr.getAttributes();
    NamingEnumeration ne = attrs.getAll();

    //System.out.println("\n");
    }
        }   
    }catch(Exception ex){
    ex.printStackTrace();
    System.exit(1);
    }
    }
    }