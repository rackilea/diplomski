sql= "INSERT INTO imt_database.Comment(error_id,user,content) VALUES (?,?,?);";
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(URL,"root","toor");
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, Error_id);
            ps.setString(2, User);
            ps.setString(3, Content);
            ps.executeUpdate();
        }catch(Exception e)