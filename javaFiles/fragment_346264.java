ResultSet rs= st.executeQuery("select email from login where email='"+user.getEmail()+"' and password='"+user.getPassword()+"'" );
if(rs.next())
 {
      return true;//if valid user, return true
 }
 else 
 return false;