<body>
       <%
           ArrayList<String> al= new ArrayList<String>();
           al.add("txt1");
           al.add("txt2");

           out.println("<input type=text id=" + al.get(0) + ">");out.println("<br>");
           out.println("<input type=text id= " + al.get(1) + ">");out.println("<br>");
           out.println("<input type=button id=btn1  value=click onClick=fun1(); > ");
       %>
 </body>

<script>
 // try the script here
</script>