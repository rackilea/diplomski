import com.documentum.fc.common.*;
import com.documentum.fc.client.*;
public class DocumentumRepoStatus
{
    static IDfSession session;
    static final String osFileSeparator = System.getProperty("file.separator");
    static String[] docbaseNames = new String[] { "test1", "test2", "test3"};
    static String userName = "user";
    static String passWd = "test123";

    static void parseArgs( String args[] )  // these are the command line args
    {
        final int MUST_HAVE_FLAGS = 1;
        int i;

        if ( args.length < (MUST_HAVE_FLAGS + 1) ) {
            System.out.println("Not enough arguments.");

        }
        else {

            for (i=0; i < args.length; i++) 
            {
                if ( ! args[i].startsWith("-") ) {
                    System.out.println("Error parsing argument: " + args[i]);
                    System.out.println("Expecting a flag parameter starting with dash ('-')");

                }
                if ( args[i].equalsIgnoreCase("-docbase_name") ) {
                    i++;
                    docbaseNames = args[i].split(" ");
                }
                if ( args[i].equalsIgnoreCase("-user_name") ) {
                    i++;
                    userName = args[i];
                }
                if ( args[i].equalsIgnoreCase("-password") ) {
                    i++;
                    passWd = args[i];
                }

            }       // end of for loop
        }           // end if if/else

        if (docbaseName.length() == 0 ) {
            System.out.println("Missing required argument -docbase_name.");

        }
        // If the user_name argument is not passed in, then trusted host for the Documentum login
        // is assumed (login as the OS user).  DFC, however requires a user name, so we will
        // retrieve the username of the current user using the Java Standard System properties.
        //
        if (userName.length() == 0 ) {
            userName = System.getProperty("user.name");

        }
    }


  static void connectToDocbase()
  {
        IDfLoginInfo li = new DfLoginInfo();
        li.setUser( userName );
        li.setPassword( passWd );
        li.setDomain( "" );
        for(int i=0;i<docBaseNames.length;i++) {
            try
            {
                IDfClient dfc = DfClient.getLocalClient();
                session = dfc.newSession(docbaseNames[i], li );
                System.out.println("Successful connection to Docbase " + docbaseName);
                getSessionInfo();
            } 
            catch (DfException e) 
            {
                System.out.println("Unable to connect to docbase: " + e.toString() );
                continue;
            }
        }
  }     

    static void getSessionInfo()
    {
        try
        {
           System.out.println("");
           System.out.println(" DM Session Properties: " );
           System.out.println(" DM Server Version    : " +  session.getServerVersion() );
           System.out.println(" DM Session ID        : " +  session.getSessionId());
           System.out.println(" DM Docbase ID        : " +  session.getDocbaseId());
           System.out.println(" DFC Version          : " +  DfClient.getDFCVersion() );
           System.out.println(" DM OwnerName         : " +  session.getDocbaseOwnerName() );


        }
        catch (DfException e)
        {
            System.out.println("Unable to retrieve DM server info: " + e );
        }
    }   


    public static void main (String[] args)
    {       
        connectToDocbase();
    }
}