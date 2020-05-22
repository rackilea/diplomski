public class able extends JFrame
{

//initialize here for easy access.  getmodel3() is the model getter method and 
//returns the defaultTableModel object

private static able frame =  new able();
private static JTable table = new JTable( getmodel3() );

//Start all main stuff here using the previously initialized objects.

public static void main(String[] args)
{
    JScrollPane scrollPane = new JScrollPane( table );
    frame.getContentPane().add( scrollPane );
    JPanel buttonPanel = new JPanel();
    frame.getContentPane().add( buttonPanel, BorderLayout.SOUTH );

    frame.setDefaultCloseOperation( EXIT_ON_CLOSE );
    frame.pack();
    frame.setVisible(true);

}   

public static void update()
{
   table.setModel(getmodel3());
}

//This method makes the table model from sql result set and returns it.    
//(found online somewhere thanks to whoever wrote it)

public static DefaultTableModel getmodel3(){
    Vector<Object> columnNames = new Vector<Object>();
    Vector<Object> data = new Vector<Object>();

    try
    {
        //  Connect to an Access Database

        String url = "jdbc:sqlite:c:\\sqlite3\\test.db";
        Connection conn = DriverManager.getConnection(url);

        //  Read data from a table

        String sql = "Select * from Tasks";
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery( sql );
        ResultSetMetaData md = rs.getMetaData();
        int columns = md.getColumnCount();

        //  Get column names

        for (int i = 1; i <= columns; i++)
        {
            columnNames.addElement( md.getColumnName(i) );
        }

        //  Get row data

        while (rs.next())
        {
            Vector<Object> row = new Vector<Object>(columns);

            for (int i = 1; i <= columns; i++)
            {
                row.addElement( rs.getObject(i) );
            }

            data.addElement( row );
        }

        rs.close();
        stmt.close();
        conn.close();
    }
    catch(Exception e)
    {
        System.out.println( e );
    }

    //  Create table with database data

    DefaultTableModel model3 = new DefaultTableModel(data, columnNames)
    {
        @Override
        public Class getColumnClass(int column)
        {
            for (int row = 0; row < getRowCount(); row++)
            {
                Object o = getValueAt(row, column);

                if (o != null)
                {
                    return o.getClass();
                }
            }

            return Object.class;
        }
    };
System.out.println("got model");

return model3;
 }

public static DefaultTableModel getmodel4(){
    Vector<Object> columnNames = new Vector<Object>();
    Vector<Object> data = new Vector<Object>();

    try
    {
        //  Connect to an Access Database

        String url = "jdbc:sqlite:c:\\sqlite3\\test2.db";
        Connection conn = DriverManager.getConnection(url);

        //  Read data from a table

        String sql = "Select * from Tasks";
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery( sql );
        ResultSetMetaData md = rs.getMetaData();
        int columns = md.getColumnCount();

        //  Get column names

        for (int i = 1; i <= columns; i++)
        {
            columnNames.addElement( md.getColumnName(i) );
        }

        //  Get row data

        while (rs.next())
        {
            Vector<Object> row = new Vector<Object>(columns);

            for (int i = 1; i <= columns; i++)
            {
                row.addElement( rs.getObject(i) );
            }

            data.addElement( row );
        }

        rs.close();
        stmt.close();
        conn.close();
    }
    catch(Exception e)
    {
        System.out.println( e );
    }

    //  Create table with database data

    DefaultTableModel model3 = new DefaultTableModel(data, columnNames)
    {
        @Override
        public Class getColumnClass(int column)
        {
            for (int row = 0; row < getRowCount(); row++)
            {
                Object o = getValueAt(row, column);

                if (o != null)
                {
                    return o.getClass();
                }
            }

            return Object.class;
        }
    };
System.out.println("got model");

return model3;
 }


}