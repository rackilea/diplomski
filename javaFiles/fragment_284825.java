public class DataBean{
     // keep all variables that needs to be transferred
}

public class MyFrame extends JFrame {
      // Frame code here

     public void openDialog() {
          new MyDialog(this,true).setVisible(true);
     }

    public void addRowToTable(DataBean data) {
       // add row to table from data 
    }
}

public class MyDialog extends JDialog {
    // Dialog display code

    DataBean data = new DataBean();
    // populate DataBean object from dialog fields
    // dispose dialog
    // call method to pass
    ((MyFrame)getOwner()).addRowToTable(data);
}