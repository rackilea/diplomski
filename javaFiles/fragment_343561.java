public void CreateQuery(String title, String year){
        try{

            Class.forName("com.mysql.jdbc.Driver");

            conn=DriverManager.getConnection(server,user,pass);
             PreparedStatement state =  conn.prepareStatement("insert into movies (title,year) values('?', ?)");
             state.setString(1, title);
             state.setInt(1, new Integer(year));
             state.executeUpdate();
             JOptionPane.showMessageDialog(null, "Query Executed");
        }

        catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

    }