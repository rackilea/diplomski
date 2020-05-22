//filePath taken from bean variable on struts
boolean fileExists = new java.io.File(getServletContext().getRealPath("/")+java.io.File.separator+filepath).exists();
if(fileExists)
{
%>
<jsp:include page='<%=correct.toString()%>' /> <br />
<%
}
else
{   
%>
<jsp:include page='<%="/html/error/error.html"%>' /> <br />
<%
}
%>