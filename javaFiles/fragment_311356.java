<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="add" method="post">
        Value 1:<input type="text" name="val1" id="val1"/><br>
        Value 2:<input type="text" name="val2" id="val2"/><br>
        <input type="submit" value="Submit"/><br>
        </form>
        <%String sum="";
         sum = (String)request.getAttribute("val3"); %>
        <input type="text" value="<%=sum%>" />
    </body>
</html>