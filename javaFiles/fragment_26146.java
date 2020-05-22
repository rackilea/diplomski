<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import ="java.sql.*" %>
<%@ page import ="java.util.Date" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
String userid   = request.getParameter("username"); 
String pwd      = request.getParameter("password"); 

Connection con       = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/XE", "klrice", "klrice");

//
// USE BINDS ! to avoid sql injection
// push the userid and passwd comparison to the db 
// no need to get the password and compare locally
// 
String query         = "select password from cmlogin where userid=? and password=?";

PreparedStatement st = con.prepareStatement(query);

// 
//  Binds in the vaules
// 

st.setString(1,userid);
st.setString(2,pwd);

ResultSet rs         = st.executeQuery(); 

String pass1;

//  .next will advance if the query has any results
// 

if ( rs.next() ) {
            pass1 = rs.getString("password");
      String name =request.getParameter("username");
      session.setAttribute("nam",name);
%> 
    <jsp:forward page="admin.jsp"></jsp:forward>
<%
    } else {
        String msg="Username or password failed";
%>
        <center> <p style="font-family:verdana;color:red;"> <%=msg %>
        <jsp:include page="Login.jsp"></jsp:include>
<%  }  %>
</body>