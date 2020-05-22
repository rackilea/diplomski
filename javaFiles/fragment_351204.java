class MyTableModel extends AbstractTableModel {


    private String[] columnNames = {"Mach",
                                    "ID",
                                    "Status",
                                    "IsActive"};

    private Vector<Vector<Object>> data = new Vector<Vector<Object>>();

    public MyTableModel() {try {
        fetchDB();
        } catch (Exception ex) {
            Logger.getLogger(Config.class.getName()).log(Level.SEVERE, null, ex);
        }
     }

    public void fetchDB ()throws Exception{

        ResultSet rs;
        Statement stmt;
        ResultSetMetaData rsmtd;

         String query = "select Mach,ID,Status,IsActive from Configs\n" +
        "order by Machine,ID";
        try {
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        String connectionUrl = "jdbc:sqlserver://192.168.100.100;" + "databaseName=DBST;" + "user=" + "user1" + ";" + "password=" + "user1pass" + ";"; 
        Connection con = DriverManager.getConnection(connectionUrl);
        stmt = con.createStatement();
        rs = stmt.executeQuery(query);
        rsmtd = rs.getMetaData();


        int columnCount = rsmtd.getColumnCount();
         while (rs.next()) {
            Vector<Object> vector = new Vector<Object>();
            for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
                vector.add(rs.getObject(columnIndex));
            }
            data.add(vector);

          }

        }

        catch(SQLException se){
        se.printStackTrace();
        } 
        catch (ClassNotFoundException ex) {
            Logger.getLogger(Config.class.getName()).log(Level.SEVERE, null, ex);
        }
  }


    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public int getRowCount() {
        return data.size();
    }

    @Override
    public String getColumnName(int col) {
        return columnNames[col];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {

        return data.elementAt(rowIndex).elementAt(columnIndex);  
    }



    @Override
    public Class getColumnClass(int c) {
        return getValueAt(0, c).getClass();
    }




}