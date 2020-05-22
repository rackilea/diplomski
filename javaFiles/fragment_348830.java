public double data(){
  double value=0.0;
  try{
     Class.forName("com.mysql.jdbc.Driver");
     Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pro","root","");

     PreparedStatement statement =  con.prepareStatement("select sum(total) from orders where status='Q' AND WEEK(date) = WEEK(CURDATE()) AND YEAR(date) = YEAR(CURDATE())");
     ResultSet result = statement.executeQuery();
     result.next();
     String sum = result.getString(1);
     System.out.println(sum);
     value = Double.parseDouble(sum);

    } catch(Exception exc){
        System.out.println(exc.getMessage());
    }
    return value;
}