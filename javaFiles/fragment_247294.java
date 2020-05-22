public class PNLSpcMaster {

   /**
    * This class attribute will be the only "instance" of this class
    * It is private so none can reach it directly. 
    * And is "static" so it does not need "instances" 
    */        
   private static PNLSpcMaster instance;

   /** 
     * Constructor make private, to enforce the non-instantiation of the 
     * class. So an invocation to: new PNLSpcMaster() outside of this class
     * won't be allowed.
     */
   private PNLSpcMaster(){} // avoid instantiation.

   /**
    * This class method returns the "only" instance available for this class
    * If the instance is still null, it gets instantiated. 
    * Being a class method you can call it from anywhere and it will 
    * always return the same instance.
    */
   public static PNLSpcMaster getInstance() {
        if( instance == null ) {
            instance = new PNLSpcMaster();
        }
         return instance;
   }
   ....
 }