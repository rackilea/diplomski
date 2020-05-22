import javax.swing.table.DefaultTableModel;

public class DefaultTableModelDemo {
  public static void main( String[] args ) {
    DefaultTableModel defaultTableModel = new DefaultTableModel();
    defaultTableModel.addRow( new Object[]{"Test", "Test"} );
    System.out.println( "defaultTableModel.getRowCount() = " + 
       defaultTableModel.getRowCount() );
    System.out.println( "defaultTableModel.getColumnCount() = " + 
       defaultTableModel.getColumnCount() );
  }
}