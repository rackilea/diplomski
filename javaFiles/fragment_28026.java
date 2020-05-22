public void startLongRunningStatement() {
  EntityManager entityManager = ...

  // Aquire session
  Session hibernateSession = ((HibernateEntityManager) em.getDelegate()).getSession();

  // Store the HibernateSession in the HttpSession
  HttpSession httpSession = servletRequest.getSession()
  httpSession.setAttribute("hibernateSession", hibernateSession);

  try {
    // Run your query  
    Query query = mEntityManager.createNativeQuery(globalQuery.toString());
    List<?> results = query.getResultList();

  } finally {
    // Clear the session object, if it is still ours
    if (httpSession.getAttribute("hibernateSession") == hibernateSession) {
      httpSession.removeAttribute("hibernateSession");
    }
  }
}

public void cancel() {
  // Get the Hibernate session from the HTTP session
  HttpSession httpSession = servletRequest.getSession()
  Session hibernateSession = (Session) httpSession.getAttribute("hibernateSession");
  if (hibernateSession != null) {
    // Cancel the previous query
    hibernateSession.cancelQuery();
  }

}