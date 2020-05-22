<%
  String status = (String) pageContext.findAttribute("status");
  if (status != null) {
      out.print(status);
  }
%>