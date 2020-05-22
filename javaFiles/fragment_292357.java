<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="MyServlet">
            <input type="text" name="operand1" size="3" value="${param['operand1']}" /> +
            <input type="text" name="operand2" size="3" value="${param['operand2']}" /> = 
            <input type="submit" value="Calculate" />
        </form>

        <div style="color: #00c; text-align: center; font-size: 20pt;">${result}</div>
    </body>
</html>