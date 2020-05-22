import java.awt.BorderLayout
import javax.swing.DefaultCellEditor
import javax.swing.JComboBox
import javax.swing.JFrame
import javax.swing.JTable
import javax.swing.table.AbstractTableModel

// Define the model class with hardcoded data
class MyModel extends AbstractTableModel {
  Object[][] data = [ [ 'a', 'one' ], [ 'b', 'two' ], [ 'c', 'three' ] ]
  String[] columnNames = [ 'Key', 'Value' ]

  int     getColumnCount()                   { columnNames?.length ?: 0 }
  int     getRowCount()                      { data?.length ?: 0 }
  String  getColumnName( int col )           { columnNames[ col ] }
  Object  getValueAt( int row, int col )     { data[ row ][ col ] }
  Class   getColumnClass( int col )          { getValueAt( col, 0 ).class }
  boolean isCellEditable( int row, int col ) { col == 1 }

  void setValueAt( Object value, int row, int col ) {
    data[ row ][ col ] = value
    fireTableCellUpdated( row, col )
  }
}

// Test the model class
table = new JTable( new MyModel() )
combo = new JComboBox( [ 'one', 'two', 'three' ] as Object[] )
table.columnModel.getColumn( 1 ).cellEditor = new DefaultCellEditor( combo )

// And make a frame to run it all in
new JFrame( 'Test' ).with {
  layout = new BorderLayout()
  add table, BorderLayout.CENTER
  pack()
  defaultCloseOperation = HIDE_ON_CLOSE
  visible = true
}