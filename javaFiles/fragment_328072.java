<%@page import="java.io.PrintWriter"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
        <select>
            <%
                PrintWriter writer = new PrintWriter( out );
                String[] strings = new String[]{ "aaa", "bbb", "ccc", "ddd" };

                for ( int i = 0; i < strings.length; i++ ) {
                    writer.printf( "<option value='%d'>%s</option>", i, strings[i] );
                }
            %>
        </select>
    </body>
</html>