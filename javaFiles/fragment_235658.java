class MyTableModel extends AbstractTableModel
{
  @Override
  public boolean isCellEditable( int rowIndex, int columnIndex )
  {
    if ( /*FILL IN YOUR REQUIREMENTS TO BE EDITABLE*/ )
     return true;

    return false
  }
}