import javax.naming.directory.*;
    public class LDAP_MultiUser_Copy1 {
    public static String INITCTX = "com.sun.jndi.ldap.LdapCtxFactory";
    public static String MY_HOST = "ldap://singh.plm.com:3890";

    public static String MY_SEARCHBASE = "cn=Public,x=X-Y,ou=people,cn=Windchill_8.0,cn=Application Services,X=X-Y";

    public static String MY_FILTER = "(&(objectclass=groupOfUniqueNames)(uniqueMember=";
    public static String MGR_DN = "cn=Manager";
    public static String MGR_PW = "ldapadmin";
    //public String[] MY_FILTER2=new String[200];
    public static void main(String[] args) throws IOException {
        String[] MY_FILTER2=new String[900];
        String[] First_Name=new String[200];
        //String[] MY_FILTER2=null;
    try{
        String fileName="C:\\report\\report.txt";
        FileReader inputFile = new FileReader(fileName);
        BufferedReader bufferReader = new BufferedReader(inputFile);
        String line;

        FileWriter writer = new FileWriter("C:\\report\\report11.csv");
        PrintWriter pwr = new PrintWriter(writer);

        String fileName1="C:\\report\\report1.txt";
        FileReader inputFile1 = new FileReader(fileName1);
        BufferedReader bufferReader1 = new BufferedReader(inputFile1);
        String line1;

        pwr.print("User");
        pwr.print(",");
        pwr.print("Group Name");
        pwr.print(",");
        pwr.println();

        int i=0;
        while (((line = bufferReader.readLine()) != null) && (line1 = bufferReader1.readLine())!= null)
        {
            //System.out.println(line);
            //System.out.println("Reading text file");
            MY_FILTER2[i]=line;
            //System.out.println("My_Filter2="+MY_FILTER2[i]);


            //First_Name = line.split(",");

            //System.out.println("MAking my_filter_final");
        String MY_FILTER_Final=MY_FILTER+line+"))";
        //System.out.println("MY_FILTER_Final="+MY_FILTER_Final);


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
    System.out.println(results);



    if((results.hasMore())==false)
    {
        System.out.println("%%%%%%%%%No Group Presnt for the USer="+line1);
        pwr.print(line1);
        pwr.print(",");
        pwr.print("No Org Group");
        pwr.print(",");
        pwr.println();
    }

    while(results != null && results.hasMore()){
        System.out.println("entering wile loop----------------");


        SearchResult sr = (SearchResult)results.next();
        if(sr==null)
        {
            System.out.println();
        }

    /*  if((SearchResult sr = (SearchResult)results.next())==null)
        {
            System.out.println("No Org Group");
            pwr.print(line1);
            pwr.print(",");
            pwr.print("No Org Group");
            pwr.print(",");
            pwr.println("");
        }*/
        else
    {
    String dn = sr.getName();
    String state = dn.substring(dn.indexOf("cn=")+3);
    //String First_Name_Final=First_Name[i].substring(First_Name[i].indexOf("cn=")+3);

    //System.out.println("Username="+line1+"@@@@@@@"+line+" Group = "+state);
    System.out.println("Username="+line1+"-->Group = "+state);
    pwr.print(line1);
    pwr.print(",");
    pwr.print(state);
    pwr.print(",");
    pwr.println("");
    i++;
    Attributes attrs = sr.getAttributes();
    NamingEnumeration ne = attrs.getAll();
    /*while(ne.hasMoreElements()) {
    Attribute attr = (Attribute) ne.next();
    String attrID = attr.getID();
    System.out.println(attrID+" :");
    Enumeration vals = attr.getAll();
    while(vals.hasMoreElements() ) {
    System.out.println("\t"+vals.nextElement());
    }
    }*/
    //System.out.println("\n");

    if (attrs == null) {
        System.out.println("Entry " + dn + " has none of the specified attributes\n");
        return;
      }

    }
        }   
        }

        pwr.close();    
    }catch(Exception ex){
    ex.printStackTrace();
    System.exit(1);

    }
    }
    }