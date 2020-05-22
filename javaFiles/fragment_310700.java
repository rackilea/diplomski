<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title></title>
    </head>
    <body>
        <%
        int status = response.getStatus();
        if (status == 401) {
            response.setStatus(403);
        }
        %>
    </body>
</html>