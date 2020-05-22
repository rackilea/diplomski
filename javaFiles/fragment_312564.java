<%@page contentType="text/html" pageEncoding="MacRoman"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%!
private static class NdBadIdea {
  private final int foo = 42;

  public int getFoo() {
    return foo;
  }
}
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=MacRoman">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <%=new NdBadIdea().getFoo()%>
    </body>
</html>