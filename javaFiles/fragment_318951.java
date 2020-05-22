// StockServerImpl.java

package StockMarket;

import java.util.Vector;

import org.omg.CORBA.*;
import org.omg.CORBA.Object;
import org.omg.CosNaming.NameComponent;
import org.omg.CosNaming.NamingContextExt;
import org.omg.CosNaming.NamingContextExtHelper;
import org.omg.CosNaming.NamingContextPackage.CannotProceed;
import org.omg.CosNaming.NamingContextPackage.NotFound;
import org.omg.PortableServer.*;
import org.omg.PortableServer.POAPackage.ServantNotActive;
import org.omg.PortableServer.POAPackage.WrongPolicy;


// StockServerImpl implements the StockServer IDL interface
public class StockServerImpl
    extends StockServerPOA
    //extends _StockServerImplBase 
    implements StockServer 
{
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    public static final String SERVICENAME = "StockServer";
    // Stock symbols and their respective values.
    private Vector<String> myStockSymbols;
    private Vector<Float> myStockValues;

    @SuppressWarnings("unused")
    private ORB orb;
    public void setORB(ORB orb_val) {orb = orb_val; }

    // Characters from which StockSymbol names are built.
    private static char ourCharacters[] = 
    { 
                         'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I',
                         'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R',
                         'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z' 
    };

    // Path name for StockServer objects.
    private static String ourPathName = "StockServer";

    // Create a new StockServerImpl.
    public StockServerImpl()
    {
        myStockSymbols = new Vector<String>();
        myStockValues = new Vector<Float>();

        // Initialize the symbols and values with some random values.
        for (int i=0; i<10; i++)
        {
            // Generate a string of four random characters.
            StringBuffer stockSymbol = new StringBuffer("    ");
            for (int j=0; j<4; j++)
                { stockSymbol.setCharAt(j, ourCharacters[(int) (Math.random() * 26f)]); }

            myStockSymbols.addElement(stockSymbol.toString());

            // Give the stock a value between 0 and 100.  In this example,
            // the stock will retain this value for the duration of the
            // application.
            myStockValues.addElement(new Float(Math.random() * 100f));
        }

        // Print out the stock symbols generated above.
        System.out.println("Generated stock symbols:");
        for (int i=0; i<10; i++)
            { 
                System.out.println( 
                                    " " + myStockSymbols.elementAt(i) 
                                  + " " + myStockValues.elementAt(i)
                );
            } 
        System.out.println();
    }

    // Return the current value for the given StockSymbol.
    @Override
    public float getStockValue(String symbol) throws InvalidStockSymbolException 
    {
        System.out.println("Getting stock value for symbol: " + symbol);
        // Try to find the given symbol.
        int stockIndex = myStockSymbols.indexOf(symbol);
        if (stockIndex != -1)
        {
            // Symbol found; return its value.
            return (myStockValues.elementAt(stockIndex).floatValue());
        }
        else
        {
            // Symbol was not found.
            throw new InvalidStockSymbolException();
        }
    }

    // Return a sequence of all StockSymbols known by this StockServer.
    @Override
    public String[] getStockSymbols() 
    {
        System.out.println("Getting stock symbols...");
        String[] symbols = new String[myStockSymbols.size()];
        myStockSymbols.copyInto(symbols);
        return symbols;
    }

    /**
     * @param ourPathName the ourPathName to set
     */
    public static void setOurPathName(String ourPathName) {
        StockServerImpl.ourPathName = ourPathName;
    }

    /**
     * @return the ourPathName
     */
    public static String getOurPathName() {
        return ourPathName;
    }

    // Create and initialize a StockServer object.
    public static void main (String args[])
    {
        NameComponent path[] = null;
        NamingContextExt ncRef = null;
        org.omg.CORBA.Object objRef = null;
        org.omg.CORBA.Object ref = null;
        StockServer href = null;
        StockServerImpl stockServerImpl = null;

        ORB orb = StockServerORBHelper.getORB(args);
        POA rootpoa = StockServerPOAHelper.getRoot(orb);

        try { stockServerImpl = new StockServerImpl(); } // Create a StockServerImpl object and register it with the ORB.
        catch (Exception ex) { System.err.println("Can't create StockServer: " + ex.getMessage()); }

        try { stockServerImpl.setORB(orb); }
        catch (Exception ex) { System.err.println("Can't set ORB on StockServer: " + ex.getMessage()); }

/*      
        try { orb.connect(stockServerImpl); }
        catch (Exception ex) { System.err.println("Can't connect ORB to StockServer: " + ex.getMessage()); ex.printStackTrace(); }
*/

        // get object reference from the servant

        try { ref = rootpoa.servant_to_reference(stockServerImpl); } 
        catch (ServantNotActive ex) { System.err.println("Can't assign servant to reference, Servant Not Active: " + ex.getMessage()); ex.printStackTrace(); } // TODO Auto-generated catch block
        catch (WrongPolicy ex) { System.err.println("Can't assign servant to reference, Wrong Policy: " + ex.getMessage()); ex.printStackTrace(); } // TODO Auto-generated catch block

        try { href = StockServerHelper.narrow(ref); }
        catch (Exception ex) { System.err.println("Can't narrow StockServer: " + ex.getMessage()); ex.printStackTrace(); }

        try { objRef = orb.resolve_initial_references("NameService"); } // Get the root naming context.
        catch (Exception ex) { System.err.println("Can't resolve NameServeice: " + ex.getMessage());  ex.printStackTrace();}

        try { ncRef = NamingContextExtHelper.narrow(objRef); }
        catch (Exception ex) { System.err.println("Can't narrow NamingContextExt: " + ex.getMessage()); }

        //NameComponent path[] = { nameComponent };
        try { path = ncRef.to_name(SERVICENAME); } 
        catch (org.omg.CosNaming.NamingContextPackage.InvalidName ex) { System.err.println("Can't name path: " + ex.getMessage()); } // TODO Auto-generated catch block

        try { ncRef.rebind(path, href); } 
        catch (NotFound ex) { System.err.println("Can't rebind ncRef, not Found: " + ex.getMessage()); } // TODO Auto-generated catch block
        catch (CannotProceed ex) { System.err.println("Can't rebind ncRef, cannot proceed: " + ex.getMessage()); } // TODO Auto-generated catch block
        catch (org.omg.CosNaming.NamingContextPackage.InvalidName ex) { System.err.println("Can't rebind ncRef, invalid name: " + ex.getMessage()); } // TODO Auto-generated catch block

/*      
        try { namingContext.rebind(path, stockServerImpl); }
        catch (Exception ex) { System.err.println("Can't rebind NameComponent to StockServer: " + ex.getMessage()); ex.printStackTrace(); }
*/

        System.out.println("StockServer ready and waiting...");

        // wait for invocations from clients
        orb.run();

        // Wait for invocations from clients.
        java.lang.Object waitOnMe = new java.lang.Object();
        synchronized(waitOnMe) 
        { 
            try { waitOnMe.wait(); } 
            catch (InterruptedException ex) 
            {
                System.err.println("Can't wait: " + ex.getMessage());
                ex.printStackTrace();
            } 
        }

        System.out.println("StockServer Exiting...");
    }

    @Override
    public Request _create_request(Context arg0, String arg1, NVList arg2,
            NamedValue arg3) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Request _create_request(Context arg0, String arg1, NVList arg2,
            NamedValue arg3, ExceptionList arg4, ContextList arg5) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Object _duplicate() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public DomainManager[] _get_domain_managers() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Policy _get_policy(int arg0) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public int _hash(int arg0) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public boolean _is_equivalent(Object arg0) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public void _release() {
        // TODO Auto-generated method stub

    }

    @Override
    public Request _request(String arg0) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Object _set_policy_override(Policy[] arg0, SetOverrideType arg1) {
        // TODO Auto-generated method stub
        return null;
    }


} // interface StockServer