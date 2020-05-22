<table border="0">
    <tr>
    <%
        for (int i = 1; i < states.size(); i++) {
            out.println("<td>" + states.get(i) + "</td>");
            if (i>0 && i%3==0) {
                out.println("</tr><tr>");
            }
        }
    %>
    </tr>
</table>