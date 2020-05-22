<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
Start Test<br>
<% try{ %>
<%
Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/dbname","user","Passowrd");
            out.println("Connected Successfully");
            PreparedStatement preparedStatement=con.prepareStatement("SELECT * FROM admin");
            ResultSet rst=preparedStatement.executeQuery();
            while(rst.next()){
                out.print("<br/>"+" "+rst.getString(1)+"  "+rst.getString(2)+"  "+rst.getString(3));
            }

            preparedStatement=con.prepareStatement("SELECT count(*),admin_id,username from admin a WHERE username='ankit' AND pwd=md5('ankit')");
            rst=preparedStatement.executeQuery();
            while(rst.next()){
                out.print("<br/>"+" "+rst.getString(1)+"  "+rst.getString(2)+"  "+rst.getString(3));
            }
%>
<%}catch(Throwable t) {t.printStackTrace(response.getWriter());}%>
</body>
</html>