<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<jsp:useBean id="id1" class="test.user" scope="session" ></jsp:useBean>

<jsp:setProperty property="*" name="id1" />

<h1> <jsp:getProperty property="name" name="id1"/> </h1>
<h1> <jsp:getProperty property="password" name="id1"/> </h1>
//==========================================
<%= id1.validate() %>
<h1> <jsp:getProperty property="message" name="id1"/> </h1>
//==========================================

</body>
</html>
//==============================================================
    public void validate() {

        if (name==null){message="name cannot be null";}
        else if(password==null) {message="passowrd cannot be null";}
        else{message="form validatuion ok";}
    }