<%
HttpSession session = request.getSession();
int role = (Integer)session .getAttribute("role");
System.out.println(" role "+ role);
if(role != 0)
{
 %>
    <a href="admin.jsp">Top Secret Link</a>
 <%
}