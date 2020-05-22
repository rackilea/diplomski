public static int GetScreenWorkingWidth() 
{
    return java.awt.GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds().width;
}

public void setMinPrefMax()
{
    for(int i = 0; i < myTable.getColumnCount(); i++) 
    {
        ////Min
        System.out.println("Column "+i);
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
        ////Pref
        for(int row=0; row<myTable.getRowCount(); row++)
        {
            Font fontF1 = myTable.getFont();
            FontMetrics cVFontMetrics = myTable.getFontMetrics(fontF1);

            System.out.println(myTable.getValueAt(row, i));
            String Hello = myTable.getValueAt(row, i)+"";
            int Test2 = cVFontMetrics.stringWidth(Hello);
            System.out.println("The length of this string is: "+Test2);
            if(Test2>testMaxPrefSize)
            {
                testMaxPrefSize = Test2;
            } 
        }
        System.out.println("The maximum value for cells in column "+i+" is: "+testMaxPrefSize);
        myTable.getColumnModel().getColumn(i).setPreferredWidth(testMaxPrefSize+20);
        ////Max
        int testMaxSize = testMaxPrefSize+300;

        if(testMaxSize>GetScreenWorkingWidth())
        {
            myTable.getColumnModel().getColumn(i).setMaxWidth(GetScreenWorkingWidth());
        }

        else
        {
            myTable.getColumnModel().getColumn(i).setMaxWidth(testMaxSize);
        }

        testMaxPrefSize=0;
    }
}