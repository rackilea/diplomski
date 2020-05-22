try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/dmsqms","root", "");
            Statement st = con.createStatement();
            String sql = "SELECT * FROM dmsmembers WHERE zid=?";//getting username
            PreparedStatement ps=con.prepareStatement(sql);
            //setting value for ?
            ps.setString(1,zid);
            ResultSet rs = ps.executeQuery();
            //checking if record with zid exist if yes do below  
            if(rs.next()){
            //put alert here
             out.println("<script type=\"text/javascript\">");
            out.println("alert('User Already Exists');");
            out.println("</script>");

            }else{
            //if zid doesn't exist insert new record
            int i = st.executeUpdate("insert into dmsmembers(zid, first_name, last_name, mailid, department, division, location, pass, regdate) values ('" + zid + "','" + fname + "','" + lname + "','" + email + "','" + department + "','" + division + "','" + location + "','" + pwd + "', CURDATE())");
            if (i > 0) {
                //response.sendRedirect("loginJSP.jsp");
                 //insert successfull alert message and redirect
                 out.println("<script type=\"text/javascript\">");
                 out.println("alert('Registration Successfull!');");
                 out.println("location='loginJSP.jsp';");
                 out.println("</script>");
                } else {
                //not inserted have some error print here

                }

            }

            } catch(Exception e){
            //print error if any
            e.printStackTrace();
        }