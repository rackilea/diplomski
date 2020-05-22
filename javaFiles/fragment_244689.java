try{
    Class.forName("com.mysql.jdbc.Driver");
    Connection con = DriverManager.getConnection("jdbc:mysql://x.x.x.x:3306/databasename", "username", "password");
    ...
}catch(Exception ex){
    ex.printStackTrace();
}