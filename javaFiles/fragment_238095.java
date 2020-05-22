<%@taglib prefix="s" uri="/struts-tags"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html> 
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>List of People</h1>
        <s:iterator value="persons">
            <s:property value="name"/> <s:property value="lastName"/><br/>
        </s:iterator>
    </body>
</html>