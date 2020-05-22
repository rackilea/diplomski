try {
     Connection con = Db.getConnection();
     Statement st = con.createStatement();

    ResultSet result = stmt.executeQuery("select name from data where name='"+name+"'");
    if(result.next())
    {
        response.sendRedirect("signup.jsp?Registration Failed");
    }
    else{
         int i = st.executeUpdate("insert into data values('" + name + "','" + pass + "','" + role + "','" + gender + "','" + age + "','" + email + "','" + date + "','NO','Waiting')");
         if (i != 0) {
                response.sendRedirect("signup.jsp?Registration Successfully");
          } 
          else {
                response.sendRedirect("signup.jsp?Registration Failed");
         }
    }
    } catch (Exception e) {
            System.out.println("Error in signupction" + e.getMessage());
        }