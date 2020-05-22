<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Hello World - JSP tutorial</title>
</head>
<body>
<%
   String user = request.getParameter("user");
   response.getWriter().println(user == null ? ("Hello World") : ("Hello World " + user)); 
%>
</body>
</html>