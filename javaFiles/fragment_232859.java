HttpSession session = request.getSession();
   if (request.getParameter("JSESSIONID") != null) {
    Cookie userCookie = new Cookie("JSESSIONID", request.getParameter("JSESSIONID"));
    response.addCookie(userCookie);
   } else {
    String sessionId = session.getId();
    Cookie userCookie = new Cookie("JSESSIONID", sessionId);
    response.addCookie(userCookie);
   }