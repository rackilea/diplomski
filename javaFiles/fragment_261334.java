rs=st.executeQuery("select * from members where email='"+user_email+"' and password='"+user_password+"'");

        if(rs.next()){
            session.setAttribute("first_name", rs.getString("first_name"));//set first_name in session
            session.setAttribute("user_email", user_email);

            response.sendRedirect("main.jsp");


   }