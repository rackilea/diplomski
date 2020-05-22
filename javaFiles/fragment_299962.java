try{
    Connection con1;
    Class.forName("com.mysql.jdbc.Driver");
    con1=(Connection)DriverManager.getConnection("jdbc:mysql://192.168.101.1:3306/dbname","username","password");
    PreparedStatement ps1=(PreparedStatement)con1.prepareStatement("SELECT * from tablename where columnname=valueofid");
    String str;
    ResultSet rs1=ps1.executeQuery();

    while(rs1.next()){
        int id=rs1.getInt("ID");
        String bookname=rs1.getString("clnmae1");
    String bookauthor=rs1.getString("clname2");

    //// there you can use label settext() method where to show your data
        }
       con1.close();

    } catch(Exception ex){
        out.print(ex);
}