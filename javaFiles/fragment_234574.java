try {
Class.forName("com.mysql.jdbc.Driver");
Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/inb", "root", "root");

//The user's password has to be converted into a salted hash before storing in the database.
String hashed_password=CreateDigest.getPasswordDigest(request.getParameter("password"));

PreparedStatement ps=con.prepareStatement("insert into inb.users values (NULL, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)", , Statement.RETURN_GENERATED_KEYS);
        ps.setString(1, request.getParameter("name1"));
        ps.setString(2, request.getParameter("name2"));
        ps.setString(3, request.getParameter("name3"));
        ps.setString(4, request.getParameter("dob"));
        ps.setInt(5, Integer.parseInt(request.getParameter("age")));
        ps.setString(6, request.getParameter("email"));
        ps.setString(7, request.getParameter("mobnum"));
        ps.setString(8, request.getParameter("address1"));
        ps.setString(9, request.getParameter("address2"));
        ps.setString(10, request.getParameter("pannum"));
        ps.setString(11, request.getParameter("aadhar"));
        ps.setString(12, hashed_password);
        ps.setString(13, request.getParameter("acc_bal"));
        ps.setInt(14, pin);

            int i=ps.executeUpdate(); 


    //Check if records have been actually been inserted or not.
            ResultSet rs = ps.getGeneratedKeys();
            if(rs.next())
            {
                int id = rs.getInt(1);
            request.setAttribute("id", id);
            request.setAttribute("pin", pin);
            request.getRequestDispatcher("AccountOpened.jsp").forward(request, response);
        }

    } catch (ClassNotFoundException | SQLException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }