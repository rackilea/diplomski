<table>
<%
...
while(rs.next()) {
    description = rs.getString("description");
    out.print("<tr bgcolor='#FFFFFF' class='style11'><td>" + description + "</td></tr>");
...
%>
</table>