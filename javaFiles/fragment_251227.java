PreparedStatement stmt = con.prepareStatement("insert into user (fname, lname, username, password)values(?,?,?,?)");
            ps.setString(1, fname);
            ps.setString(2, lname);
            ps.setString(3, username);
            ps.setString(4, password);
            ps.executeUpdate();