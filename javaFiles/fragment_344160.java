import org.omg.CORBA.ORB;
import org.omg.CosNaming.NameComponent;
import org.omg.CosNaming.NamingContext;
import org.omg.CosNaming.NamingContextExt;
import org.omg.CosNaming.NamingContextExtHelper;
import org.omg.CosNaming.NamingContextHelper;
import org.omg.PortableServer.POA;
import org.omg.PortableServer.POAHelper;

import FileTransferApp.*;

public class StartServer {
   public static void main(String args[]) {
      try{
         // create and initialize the ORB
         ORB orb = ORB.init(args, null);
         POA rootpoa = POAHelper.narrow(orb.resolve_initial_references("RootPOA"));
         rootpoa.the_POAManager().activate();

         // create the servant and register it with the ORB
         FileTransferObj fileRef = new FileTransferObj();
         fileRef.setORB(orb);

         //get Object reference from servant
         org.omg.CORBA.Object ref =  rootpoa.servant_to_reference(fileRef);
         FileInterface href = FileInterfaceHelper.narrow(ref);

         // get the root naming context
         org.omg.CORBA.Object objRef =
            orb.resolve_initial_references("NameService");
         NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);

         //
         NameComponent path[] = ncRef.to_name("ABC");
         ncRef.rebind(path, href);

         System.out.println("Server started....");
         // Wait for invocations from clients
         for(;;){
            orb.run();
         }
      } catch(Exception e) {
         System.err.println("ERROR: " + e.getMessage());
         e.printStackTrace(System.out);
      }
   }
}