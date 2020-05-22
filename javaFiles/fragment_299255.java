<%
String integer = request.getParameter("fno");     
String integer1 = request.getParameter("sno"); 
int x = integer != null ? Integer.parseInt(integer) : 0;      
int y = integer1 != null ? Integer.parseInt(integer1) : 0;
int z=x+y;
 %>
 <input type="text" name="integer" value="<%=z%>"/>