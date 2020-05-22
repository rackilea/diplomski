String user = req.getParameter("userName");
  String pass = req.getParameter("userPassword");
  String id=null;
  String userId=null;

  String sql = "SELECT id, userId, password FROM login where username='"+user+"' and password='"+pass+"'";
        ResultSet rs = stmt.executeQuery(sql);
while(rs.next())
 {
 id=rs.getString("id");
userId=rs.getString("userId");   
}

if(id!=null)
System.out.println("Login Success");
else
System.out.println("Login Failed");