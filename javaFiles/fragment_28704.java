import javax.swing.event.TableModelEvent;
import javax.swing.table.DefaultTableModel;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Vector;

public class ReadFileGUI extends javax.swing.JFrame {
  private DefaultTableModel tableModel = new DefaultTableModel();
  private javax.swing.JButton populateTableButton;
  private javax.swing.JScrollPane tableScrollPane;
  private javax.swing.JTable table;

  public ReadFileGUI() {
    initComponents();
    setDefaultCloseOperation( javax.swing.WindowConstants.EXIT_ON_CLOSE);
  }

  @SuppressWarnings("unchecked")
  private void initComponents() {
    populateTableButton = new javax.swing.JButton();
    tableScrollPane = new javax.swing.JScrollPane();
    table = new javax.swing.JTable( tableModel );

    populateTableButton.setText( "Test" );
    populateTableButton.addActionListener( new ActionListener() {
      @Override
      public void actionPerformed( ActionEvent evt ) {
        populateTable();
      }
    } );

    tableScrollPane.setViewportView( table );

    getContentPane().setLayout( new BorderLayout(  ) );
    getContentPane().add( tableScrollPane, BorderLayout.CENTER );
    getContentPane().add( populateTableButton, BorderLayout.SOUTH );
    pack();
  }


  private void populateTable( ) {
    String line = "Hello~There~This~Is~A~Test";
    String dataValue[] = line.split("~");
    Vector<String> v = new Vector<>( Arrays.asList( dataValue ));
    tableModel.setColumnCount( v.size() );
    tableModel.addRow( v );
  }

  public static void main(String args[]) {
    java.awt.EventQueue.invokeLater(new Runnable() {
      @Override
      public void run() {
        new ReadFileGUI().setVisible(true);
      }
    });
  }         
}