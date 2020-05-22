final String CURRENT_USER_KEY = "CURRENT_USER";

EntityManager em; // somewhere initialized
Integer userid; //  somewhere initialized

HttpSession session =  httpServletRequest.getSession();
User user = session.getAttribute(CURRENT_USER_KEY);

if(user == null){
  User user = em.find(User.class, userId);
  session.setAttribute(CURRENT_USER_KEY, user);
}

// perform further actions on your user