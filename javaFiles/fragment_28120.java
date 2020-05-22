if (login == null){
   out.println("<html><body>");
   out.println("<center><h1>Login failed, wrong username or password</h1></center>");
   out.println("</body>");
   out.println("<script type='text/javascript'>");
   out.println("function reload() {");
   out.println("setTimeout(function(){");
   out.println("window.location = '"+request.getContextPath()+"/search';}");
   out.println("}, 5000);");
   out.println("reload();");
   out.println("</script>");
   out.println("</html>");
}