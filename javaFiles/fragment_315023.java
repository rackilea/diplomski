public class <class handler> {
   @Execute
   public void execute(MMenuItem menuItem, ...) {
      String param = (<Type>) menuItem.getTransientData().get(<name>); // Get parameter back
      // Put your logic here linked to the menu entry
   }
}