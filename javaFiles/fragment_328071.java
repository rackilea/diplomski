<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
        <select>
            <%
                String[] strings = new String[]{ "aaa", "bbb", "ccc", "ddd" };

                for ( int i = 0; i < strings.length; i++ ) {
                    out.print( String.format( "<option value='%d'>%s</option>", i, strings[i] ) );
                }
            %>
        </select>
    </body>
</html>