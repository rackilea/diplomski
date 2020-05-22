DAO daoUser = new DAO();   /// i create object of DAO
 List<User> users = daoUser.select();  //calling select to get list of users
 out.write("<table>");
 for(User user : users){ //Running through the list to show all users retrived
    out.write("<td>");
    out.write("<p>"+user.id+"</p>");    
    out.write("</td>");
    out.write("<td>"); 
    out.write("<p>"+user.name+"</p>");    ///
    out.write("</td>");
 }
 out.write("</table>");