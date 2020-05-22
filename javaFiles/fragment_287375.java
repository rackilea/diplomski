<%
Enumeration paramNames = request.getParameterNames();
while(paramNames.hasMoreElements()) {
  String paramName = (String)paramNames.nextElement();
  out.print("<b>" + paramName + ":</b>\n");
  String paramValue = request.getHeader(paramName);
  out.println(paramValue);
}
%>