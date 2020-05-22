public class TableModelDecorator implements TableModel{
  private TableModel delegate;
  private JTable table;

  @Override
  public Object getValueAt( int rowIndex, int columnIndex ) {
    return delegate.getValueAt( table.convertRowIndexToView( rowIndex ), table.convertColumnIndexToView( columnIndex ) );
  }
}