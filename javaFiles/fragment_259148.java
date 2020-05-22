...
    String[] numbers0 = Periodparagraphs.text().toString().split(" ");
    String[] numbers = SSPparagraphs.text().toString().split(" ");//takes the ...
    String[] numbers1 = SBPparagraphs.text().split(" ");

    int tableRows;

    if (numbers0.length > numbers.length && numbers0.length > numbers1.length)
    {
        tableRows = numbers0.length;
    }
    else if (numbers.length > numbers0.length && numbers.length > numbers1.length)
    {
        tableRows = numbers.length;
    }
    else
    {
        tableRows = numbers1.length;
    }
    //model = new DefaultTableModel(col, 90);//50 is number of rows --You don't seem to need this

    Object[][] data = new Object[tableRows][3];

    for (int x = 0; x < tableRows; x++ )
    {
        try
        {
            data[x][0] = numbers1[x];
        }
        catch (IndexOutOfBoundsException e)
        {
            data[x][0] = "-";
        }

        try
        {
            data[x][1] = numbers[x];
        }
        catch (IndexOutOfBoundsException e)
        {
            data[x][1] = "-";
        }

        try
        {
            data[x][2] = numbers0[x];
        }
        catch (IndexOutOfBoundsException e)
        {
            data[x][2] = "-";
        }
    }



    table = new JTable(data,col) 
    {
        @Override

        public boolean isCellEditable(int arg0, int arg1) 
        {
            return false;
        }
    };