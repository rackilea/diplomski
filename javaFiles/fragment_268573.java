import java.awt.Color;
import java.awt.Component;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;

public class JTableExample extends JFrame {

 String data[][] = {{"John", "Sutherland", "Student"},
   {"George", "Davies", "Student"},
   {"Melissa", "Anderson", "Associate"},
   {"Stergios", "Maglaras", "Developer"},
 };

 String fields[] = {"Name", "Surname", "Status"};

 public static void main( String[] argv ) {
  JTableExample myExample = new JTableExample( "JTable Example" );
 }

 /**
  * @param title
  */
 public JTableExample( String title ) {
  super( title );
  setSize( 150, 150 );
  addWindowListener( new WindowAdapter() {
   public void windowClosing( WindowEvent we ) {
    dispose();
    System.exit( 0 );
   }
  } );
  init();
  pack();
  setVisible( true );
 }

 private void init() {

  final CustomCellRenderer renderer = new CustomCellRenderer();        
  JTable jt = new JTable( data, fields ) {

   @Override
   public TableCellRenderer getCellRenderer(int row, int column) {
    // TODO Auto-generated method stub
    return renderer;
   }

  };
  JScrollPane pane = new JScrollPane( jt );
  getContentPane().add( pane );
 }


 /**
  * @author suhas
  *
  */
 private class CustomCellRenderer extends DefaultTableCellRenderer {

  /* (non-Javadoc)
   * @see javax.swing.table.DefaultTableCellRenderer#getTableCellRendererComponent(javax.swing.JTable, java.lang.Object, boolean, boolean, int, int)
   */
  public Component getTableCellRendererComponent(JTable table, Object value,
    boolean isSelected, boolean hasFocus, int row, int column) {

   Component rendererComp = super.getTableCellRendererComponent(table, value, isSelected, hasFocus,
     row, column);

   //Set foreground color
   rendererComp.setForeground(Color.red);

   //Set background color
   rendererComp .setBackground(Color.blue);

   return rendererComp ;
  }

 }

}