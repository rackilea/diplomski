class FooPanel extends JPanel {
   private FooFrame fooFrame;

   // constructor accepts a reference to a FooFrame object
   public FooPanel(FooFrame fooFrame) {
      this.fooFrame = fooFrame; // and sets its field with it
   }

   public void otherMethod() {
      // no longer needed!
      // FooFrame fooFrame = new FooFrame(); 


      // now method is called on the right object!
      fooFrame.someMethod(); 
   }
}