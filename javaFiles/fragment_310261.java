public String[] selectQuery(){
    String[] result = null;

    try{
      Class.forName("com.mysql.jdbc.Driver").newInstance();
      String hostcompleto = "jdbc:mysql://"+host+":3306/"+name;
      conn = DriverManager.getConnection(hostcompleto, user, password);