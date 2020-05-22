public class ForwardReference {        
   public ForwardReference() {
      super();
   }

   public ForwardReference echoReference() {
      return this;
   }

   public void testLegalForwardReference() {
      // Illustration: Legal
      this.x = 5;
   }

   private int x = 0;

   // Illustration: Illegal
   private ForwardReference b = a.reference();
   private ForwardReference a = new ForwardReference();
}