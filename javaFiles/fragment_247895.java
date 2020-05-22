String column[]= { "Name","Position","Phone"};
    Object [][]row = {
            {"Prof. Renu Vig", "Director", "+123456"},
            {"Mr. Sukhbir singh", "Assistant Professor", "+9123568989"},
            {"Ms. shaweta", "BI teacher","9468645"}
    };

    JTable table = new JTable(row,column);
    TableModel tm = table.getModel();
    java.sql.Connection con=null;
    try
    {

        Class.forName("com.mysql.jdbc.Driver");
        con=DriverManager.getConnection("jdbc:mysql://localhost:3306/training","root","");

        java.sql.Statement stmt =con.createStatement();
        String maketable = "CREATE TABLE if not exists contacttable(Name Varchar(25),Position Varchar(20),Phone Varchar(20))";
        stmt.executeUpdate(maketable);
        System.out.print("table created ");

        PreparedStatement pstmt=con.prepareStatement("INSERT INTO contacttable VALUES(?,?,?)");

        for (int i = 0; i < tm.getRowCount(); i++) {
            for (int j = 0; j < tm.getColumnCount(); j++) {
                Object o = tm.getValueAt(i, j);
                System.out.println("object from table is  : " +o);
                pstmt.setString(j+1, (String)o);
            }
             pstmt.executeUpdate();
             pstmt.clearParameters();
        }
    }
    catch (Exception e) {
        e.printStackTrace();
    }