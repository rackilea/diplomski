if ("/RegForm".equals(url)) {
        request.getRequestDispatcher("/index.jsp").forward(request, response);
        return;
    } else if ("/Signup".equals(url)) {
        //dddddddd
        try {
            // Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/deneme", "root", "");

            PreparedStatement preparedStatement = null;


            // Execute SQL query
            String  insert= "INSERT INTO students (name, id, `gpa`) VALUES (?,?,?)"; 

            conn.setAutoCommit(false);
            preparedStatement = con.prepareStatement(insert);
            //Assume all paramaters as String
            preparedStatement.setString(1, request.getParameter("st_name"));
            preparedStatement.setString(2, request.getParameter("st_id"));
            preparedStatement.setString(3, request.getParameter("st_gpa"));
            preparedStatement.executeUpdate();
            conn.commit();
        } catch (Exception se) {
            //Handle errors for JDBC
        }

        request.getRequestDispatcher("/register_action.jsp").forward(request, response);
        return;
    }