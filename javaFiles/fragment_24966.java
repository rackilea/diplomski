/**
 * Example for CompoundRenderer
 * 
 * @author ymene
 */
public class CompoundRendererExample extends JPanel
{

  public static void main( String[] args )
  {
    JFrame frame = new JFrame( "Example for rendering JTable - values with CompoundRenderer" );
    frame.setDefaultCloseOperation( WindowConstants.EXIT_ON_CLOSE );
    frame.add( new CompundRendererExample() );
    frame.pack();
    frame.setVisible( true );
  }

  public CompoundRendererExample()
  {
    JScrollPane scrollPane = new JScrollPane();
    JXTable table;

    table = new JXTable( new TableModel() );
    table.setFillsViewportHeight( true );

    for ( int i = 0; i < table.getModel().getColumnCount(); i++ )
      table.getColumn( i ).setPreferredWidth( 200 );

    scrollPane.setViewportView( table );
    add( scrollPane );

    //Declaring compound-renderer
    table.setDefaultRenderer( FloatBool.class, new FloatBoolRenderer() );
  }
}


class TableModel extends AbstractTableModel
{
  private String[]   columnNames = { "Float-Boolean" };
  private Object[][] data        = { { new FloatBool( 2.2f, true ) }, { new FloatBool( 3.2f, false ) } };

  public int getColumnCount()
  {
    return columnNames.length;
  }

  public int getRowCount()
  {
    return data.length;
  }

  @Override
  public String getColumnName( int col )
  {
    return columnNames[ col ];
  }

  public Object getValueAt( int row, int col )
  {
    return data[ row ][ col ];
  }

  @Override
  public Class getColumnClass( int c )
  {
    if ( getValueAt( 0, c ) == null )
      return Object.class;
    return getValueAt( 0, c ).getClass();
  }

  @Override
  public boolean isCellEditable( int row, int col )
  {
    return true;
  }

  @Override
  public void setValueAt( Object value, int row, int col )
  {
    data[ row ][ col ] = value;
    fireTableCellUpdated( row, col );
  }
}


class FloatBoolRenderer extends DefaultTableCellRenderer
{
  JLabel    floatPartLabel;
  JCheckBox booleanPartCheckBox;
  JPanel    container;

  public FloatBoolRenderer()
  {
    floatPartLabel = new JLabel();
    booleanPartCheckBox = new JCheckBox();
    container = new JPanel();

    container.setLayout( new BorderLayout() );
    container.add( floatPartLabel, BorderLayout.CENTER );
    container.add( booleanPartCheckBox, BorderLayout.EAST );
    container.setVisible( true );
  }

  @Override
  public Component getTableCellRendererComponent( JTable table, Object value, boolean isSelected,
                                                  boolean hasFocus, int row, int column )
  {
    if ( value != null )
    {
      super.getTableCellRendererComponent( table, value, isSelected, hasFocus, row, column );

      if ( value instanceof FloatBool )
      {
        FloatBool floatboolean = (FloatBool) value;
        booleanPartCheckBox.setSelected( floatboolean.getBooleanValue() );
        floatPartLabel.setText( "" + floatboolean.getFloatValue() );
      }
    }

    return container;
  }
}


class FloatBool
{
  float   floatValue;
  boolean booleanValue;

  public FloatBool( float floatValue, boolean booleanValue )
  {
    this.floatValue = floatValue;
    this.booleanValue = booleanValue;
  }

  public boolean getBooleanValue()
  {
    return booleanValue;
  }

  public float getFloatValue()
  {
    return floatValue;
  }
}