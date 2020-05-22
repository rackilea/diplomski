import java.sql.*;
class DBQuery1{
    public static void main(String args[]) throws SQLException
  {
            try{
               Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
               }catch(ClassNotFoundException e){};
        Connection cnn;
        Statement mystmt;
        ResultSet myrs;
            String op = "jdbc:odbc:JavaTest";
        cnn = DriverManager.getConnection(op,
                 "Admin", "");
        mystmt = cnn.createStatement();
            String sql;
            sql = "SELECT * FROM SupplierMaster " +
              "WHERE SupplierCode IN ( " +
                    "SELECT SCode " +
                    "FROM Relation " +
                    "WHERE PCode IN ( " +
                          "SELECT ProductCode " +
                          "FROM ProductMaster " +
                          "WHERE ProdCatg IN ( " +
                                "SELECT CatgID " +
                                "FROM CategoryMaster " +
                                            "WHERE CategoryName = 'Eatables')))";
        myrs = mystmt.executeQuery(sql);
            System.out.println("   "+"Sup Code" + "       " +"Sup Name" + "    " + "Sup Address    ");
            System.out.println("--------------------------------------------------------------------");
        String name, add;
            int code;
            while (myrs.next())
        {
             code = myrs.getInt("SupplierCode");
             name = myrs.getString("SupplierName");
             add = myrs.getString("SupplierAddress");
             System.out.println("       " + code +"       " + name+"        " + add);
        }
  }