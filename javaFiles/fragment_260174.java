HttpSession session = request.getSession(false);// don't create new Session
if(session == null || session.isNew()) {
     response.sendRedirect("/yourPage.jsp");
} else {
    //Do whatever you waana do
}