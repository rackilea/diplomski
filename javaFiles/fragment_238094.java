<%@taglib prefix="s" uri="/struts-tags"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html> 
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Person Form</title>
    </head>
    <body>
        <h1>Person Form</h1>
        <s:form action="person-test" method="post">
            <s:textfield name="persons[0].name" label="fName 1"/>
            <s:textfield name="persons[0].lastName"  label="lName 1"/>
            <s:textfield name="persons[1].name" label="fName 2"/>
            <s:textfield name="persons[1].lastName" label="lName 2"/>
            <s:submit/>
        </s:form>
    </body>
</html>