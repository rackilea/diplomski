// why abstract? I've removed that
// no longer extends frame
public class RemoveButton implements ActionListener {
   // I've renamed your frame class to "MyFrame"
   private MyFrame myFrame;

   // constructor that allows you to pass in MyFrame reference
   public RemoveButton(MyFrame myFrame) {
      this.myFrame = myFrame;  // assign to field
   }

   public void actionPerformed(ActionEvent evt) {
      JTable table = myFrame.getTable(); // give MyFrame this method
      DefaultTableModel model = (DefaultTableModel) table.getModel();
      // .... etc
   }      
}