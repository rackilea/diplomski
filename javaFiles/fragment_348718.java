<%@ page session="false" import="java.util.*" %>
<%
  HttpSession session = request.getSession(false);
  if(session == null){
                  out.print("Error, No Session!");
                  return;
  }
  long creationTime = session.getCreationTime();
  long now = new Date().getTime();
  long lastAccessedTime = session.getLastAccessedTime();
  int oldInterval = session.getMaxInactiveInterval();
  int inactivePeriod = (int)(now - lastAccessedTime)/1000; 
  session.setMaxInactiveInterval(oldInterval - inactivePeriod); 
  int newInterval = session.getMaxInactiveInterval();
%>
<html>
<body>
session id is <%=session.getId()%>
<br/><%=creationTime%> = creationTime
<br/><%=lastAccessedTime%> = lastAccessedTime
<br/><%=now%> = now
<br/><%=oldInterval%> = oldInterval in seconds 
<br/><%=inactivePeriod%> = inactivePeriod
<br/><%=newInterval%> = newInterval in seconds 
</body>
</html>