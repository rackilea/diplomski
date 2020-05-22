protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
{
  if(!"WebSocket".equals(request.getHeader("Upgrade")))
  {
     org.eclipse.jetty.server.Request jettyRequest =  org.eclipse.jetty.server.Request.getRequest(request);
     jettyRequest.getEndPoint().close();
     jettyRequest.setHandled(true);
  }
  else
  {
     super.service(request, response);
  }
}