public enum ExtendibleEnum {

   FOO, BAR, ZXC;

   private Runnable anotherMethodRunme;  // exact Interface will vary, I picked an easy one
                           // this is what gets "injected" by your other class

   public void setAnotherMethodRunMe(Runnable r) {  // inject here
      anotherMethodRunme= r;
   }

   public void anotherMethod() {  // and this behavior gets changed
      anotherMethodRunme.run();
   }
}