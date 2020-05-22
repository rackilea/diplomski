for (int i = 0; i < myTable.getColumnCount(); i++) 
{
    JTableHeader tableHeader = myTable.getTableHeader();
    FontMetrics headerFontMetrics = tableHeader.getFontMetrics(tableHeader.getFont());

    if(tableHeader == null) 
    {
        return;
    }

    int Test = headerFontMetrics.stringWidth(myTable.getColumnName(i));
    System.out.println("The width of the column header "+i+" is: "+Test);
    int minLength = Test+20;
    myTable.getColumnModel().getColumn(i).setMinWidth(minLength);
}