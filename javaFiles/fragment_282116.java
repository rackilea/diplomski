public static HashMap<String,String>  getDetails(user u) {
    Connection con=ConnectionProvider.getCon(); 
    String uname=u.getUname();
    Map<String,String> map=new HashMap<>();
    try {
        PreparedStatement ps=con.prepareStatement("select email,pass from  S1.USER432 where name='"+uname+"'");
        ResultSet rs = ps.executeQuery();       

        while (rs.next()) {

            String email = rs.getString("EMAIL");
            String pass = rs.getString("PASS");

            }
       map.put("email",email);
       map.put("password",pass);


    } catch (SQLException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }       
    return map;
    }
}