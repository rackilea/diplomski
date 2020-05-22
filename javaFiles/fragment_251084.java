Get Logged User Id In Servlet Using Session.

HttpSession session=request.getSession(true); 
session.setAttribute("user", userLoggedId);


Later You can retrieve Session Data :

HttpSession session=request.getSession(true); 
String userId=(String)session.getAttribute("user");