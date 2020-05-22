if (session.getAttribute("loggedIn") == null) {
     response.sendRedirect("login.jsp");
} else if(session.getAttribute("loggedIn").equals("admin")) {
     response.sendRedirect("admin.jsp");
} else if(!session.getAttribute("loggedIn").equals("user")) {
     response.sendRedirect("index.jsp");
}