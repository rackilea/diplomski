String userid = request.getParameter("username");
String pwd = request.getParameter("password");

// check for empty username or password before making a call to database
if (userid == null || userid.trim().length() == 0 || pwd == null
        || pwd.trim().length() == 0) {
   out.println("Invalid username or password <a href='index.jsp'>try again</a>");
} else {
   ... // request for database query
   if (rs.next()) { // use if instead of while to check for no record
   ...
   } else {
     out.println("Empty username or password <a href='index.jsp'>try again</a>");
   }
}