<%@ page import = "java.util.ResourceBundle"
%><%
   ResourceBundle resource = ResourceBundle.getBundle("config");
   String names = resource.getString("name");
   String[] env = resource.getString("envs").split(",\\s*");
   String turls = resource.getString("tokenurl");

   String tech = request.getParameter("tech");
   if (tech != null && tech.equals("google")) {
       String url = response.encodeRedirectURL(env[13]);
       response.sendRedirect(url); // Just tell the browser to redirect, load the url.
       return;
   }
%>