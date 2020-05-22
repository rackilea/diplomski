<%@ page language="java" import="java.util.*" %> 
<%@ page import = "java.util.ResourceBundle" %>
<% ResourceBundle resource = ResourceBundle.getBundle("test");
  String name=resource.getString("pname");
  String surname=resource.getString("psurname"); %>
  <%=name %>
 <%=surname%>