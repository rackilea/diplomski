<body>
<%
    out.println("<table >");
    int apps = 16;
    double rowColumn = Math.sqrt(apps);
    boolean flag = true;
    for (double i = rowColumn; i > 0; i--) {
        String rowContent = "";
        out.println("<tr>");
        if(flag) flag = false;
        else flag = true;
        for (double j = rowColumn; j > 0; j--) {
            if(flag) {
                rowContent = "<td>" + apps + "</td>" + rowContent;

            }
            else {
                rowContent =  rowContent +"<td>" + apps + "</td>";

            }
            //out.println("<td>" + apps + "</td>");
            apps--;
        }
        out.println(rowContent);
        out.println("</tr>");
    }
    out.println("</table>");
%>
</body>