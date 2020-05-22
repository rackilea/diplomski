<%@ page contentType="applicaton/octet-stream" %><%
byte[] data = getBinaryFromSomeWhere(request.getParameter("xyz"));
response.setHeader("Content-length", Integer.toString(data.length));
response.setHeader("Content-Disposition", "attachment; filename=xyz.bin");
response.getOutputStream().write(data, 0, data.length);
response.getOutputStream().flush();
%>