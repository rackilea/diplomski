<%
String str = "";
String userid = request.getParameter("usr");
session.putValue("userid", userid);
String pwd = request.getParameter("pwd");
Class.forName("com.mysql.jdbc.Driver");
java.sql.Connection con = DriverManager.getConnection(
        "jdbc:mysql://localhost:3306/pr", "root", "xxx");
Statement st = con.createStatement();
ResultSet rs = st
        .executeQuery("select * from a where name='"+ userid + "'");
if (rs.next()) {
    if (rs.getString(2).equals(pwd)) {
        out.println("welcome " + userid);
       // str = "correct.jsp";  
   %>
       <jsp:forward page="correct.jsp"></jsp:forward>
    <%
    } else {
        out.println("Invalid password try again");
       // str = "login.jsp"; 
   %>

       <jsp:forward page="login.jsp"></jsp:forward>
    <%
    }
}
%>