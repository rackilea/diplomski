pstmt.setString(1, username);
ResultSet rs=pstmt.executeQuery();

try {
  while(rs.next()) {
    String pass=rs.getString(1);
    System.out.println(""+pass);
    if(pass.equals(password)) {
        out.print("Welcome back"+username);
    } else {
        out.print("Wrong username/password combination");
    }
  }
}     
catch(Exception e) {
  e.printStackTrace();
}