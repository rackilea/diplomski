public static void main(String[] args) throws Exception{
  ConnectionImpl con = (ConnectionImpl) DriverManager.getConnection("jdbc:mysql://localhost:3908/mydb?user=edalorzo&password=mandrake");

   System.out.println(con.getProperties().get("password"));

   con.close();
}