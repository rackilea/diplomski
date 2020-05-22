<%
        String[][] activityList=(String[][])request.getAttribute("activity");
        String[] nameList=(String[])request.getAttribute("name");

        out.print("<table border='1'>");
        out.print("<tr>");
        out.print("<td>Name</td>");
        out.print("<td>Hobby</td>");
        out.print("</tr>");
        for(int i=0;i<activityList.length;i++){
            String [] a=activityList[i];
            for(String h:a){
                out.print("<tr>");
                out.print("<td>"+nameList[i]+"</td>");
                out.print("<td>"+h+"</td>");
                out.print("</tr>");
            }
        }
        out.print("</table>");
    %>