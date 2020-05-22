//Now we can use this like this, i looked at your code and saw you wanted to have a list of UserBean objects.. we can do that like this:
public List<UserBean> adminPanel(){
    ArrayList<UserBean> users = new ArrayList<UserBean>();
    //get connection from our DBConneciton class we created earlier
    try(Connection conn= DBConnection.getConnection()){
    //create our sql statement
   PreparedStatement pst = conn.prepareStatement("select firstname,lastname,username,tipo from idusuario;"); 
         //execute query
         pst.executeQuery();   
       //now get results
    ResultSet rs = pst.executeQuery();
      //while ResultSet has results
     while (rs.next()) {
    //create new user object to hold the info in
    UserBean user = new UserBean();
    //get the results from resultset     
    String firstname = rs.getString(1);
    String lastname = rs.getString(2);
    String username = rs.getString(3);
    int type = rs.getInt(4);
    //set results to user object
    user.setFirstName(firstname);
    user.setLastName(lastname);
    user.setUserName(username);
    user.setType(type);

    users.add(user); //add userobject to list of userobjects

      }

        } catch (SQLException e) {
            e.printStackTrace();
        }
     //we don't need to close our db connection because the try statement does it for us   
return users; //return list of users
}