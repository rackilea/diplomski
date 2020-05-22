public class FooFrame extends JFrame {

   private JTextField myTextField = new JTextField(10);
   private FooPanel fooPanel;

   public FooFrame() {
      // the current FooFrame object is this!
      fooPanel = new FooPanel(this);
      add(fooPanel);
   }

   public String someMethod() {
      return myTextField .getText();
   }
}