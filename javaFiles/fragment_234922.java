public List<User> select(){
    List<User> result = new ArrayList<User>();
    try{
        Class.forName(jdbcDriver);
        Connection conn = DriverManager .getConnection(connectionString,username,password);
    PreparedStatement create = conn.prepareStatement("select * from student.users");

        ResultSet rs;
        rs = create.executeQuery();
        while(rs.next()){
            int id =rs.getInt("id");
            String name = rs.getString("fname");
            User user = new User(); // Creating a user object to fill with user data (I imagine that you have a user class in your model)
            user.setId(id);
            user.setName(name);
            //Add the retrived user to the list
            result.add(user);

        }
        //Returning the list of users.
        return result;
    }catch(Exception e){
        e.printStackTrace();
        return null;
    }

}