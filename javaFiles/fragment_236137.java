public static void main(String args[]) throws Exception {
   ORB orb = ORB.init(args, null);
   // pass the IOR as command line parameter for this program
   String ior = args[0];
   org.omg.CORBA.Object objRef = orb.string_to_object(ior);
   NamingContextExt nameService = NamingContextExtHelper.narrow(objRef);

   // Now you can work with your naming service. 
}