private void adjust(@SuppressWarnings("unused") ActionEvent event)
{
   TableColumn column;
   int count, old, next, value, x, max;

   count = m_model.getColumnCount();

   if (m_colIndex >= count)
      return;

   x      = getX(m_colIndex);
   value  = m_bar.getValue();
   column = m_model.getColumn(m_colIndex);
   old    = column.getPreferredWidth();
   max    = column.getMaxWidth();
   next   = 200;

   column.setPreferredWidth(next);
   m_colIndex++;

   if (x < value)
      m_bar.setValue(value + Math.min(next, max) - old);
}

private int getX(int colIndex)
{
   TableColumn column;
   int result;

   result = 0;

   while (--colIndex >= 0)
   {
      column  = m_model.getColumn(colIndex);
      result += column.getPreferredWidth();
   }

   return(result);
}