<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registration</title>
    </head>
    <body>
        <h1>Registration</h1>
        <p>Please fill in the form below, then click on the 'Register'
            button</p>
        <form action="register" method="post">
            <dl>
                <dt><label for="username">Username: </label></dt>
                <dd><input type="text" id="username" name="username"></dd>
                <dt><label for="password">Password: </label></dt>
                <dd><input type="password" id="password" name="password"></dd>
                <dt><label for="password">Verification: </label></dt>
                <dd><input type="password" id="verification" name="verification"></dd>
                <dt><label for="firstname">First name: </label></dt>
                <dd><input type="text" id="firstname" name="firstname"></dd>
                <dt><label for="lastname">Last name: </label></dt>
                <dd><input type="text" id="lastname" name="lastname"></dd>
                <dt><label for="email">E-mail address: </label></dt>
                <dd><input type="text" id="email" name="email"></dd>
                <dd><input type="submit" name="register" value="Register"></dd>
            </dl>
        </form>
    </body>
</html>