JTable table = new JTable( model )
{
  @Override
  public boolean isCellEditable( int row, int column )
  {
    return false;
  }
};