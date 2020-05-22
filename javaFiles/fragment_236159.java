<!DOCTYPE html>
<html lang="en"
    xmlns:f="http://java.sun.com/jsf/core"
    xmlns:h="http://java.sun.com/jsf/html"
    xmlns:ui="http://java.sun.com/jsf/facelets">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <title>Login</title>
    </head>
    <body>
    <h:form>
        Username: <h:inputText value="#{userBean.username}" />
        <br />
        Password: <h:inputText value="#{userBean.password}" />
        <br />
        <h:commandButton value="Login" action="#{userBean.getNextPage}" />
    </h:form>
</body>