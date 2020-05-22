<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Authentication</title>
    </head>
    <body>
        <h1>Authentication</h1>
        <p>Please enter your username and password below, then click on the
            'Login' button</p>
        <form action="j_security_check" method="POST">
            <dl>
                <dt><label for="j_username">Username: </label></dt>
                <dd><input type="text" id="j_username" name="j_username"></dd>
                <dt><label for="j_password">Password: </label></dt>
                <dd><input type="password" id="j_password" name="j_password"></dd>
                <dd><input type="submit" name="login" value="Login"></dd>
            </dl>
        </form>
        <p>If you don't own an account yet, and would like to register,
            <a href="register.jsp">please click here</a></p>
    </body>
</html>