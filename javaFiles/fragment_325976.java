/**
   * This method is called by JAX-RS for each request before 
   * the identified resource method is invoked, since it is 
   * annotated with the Context Annotation and carries a 
   * context-scope parameter which is injected.
   */
  @Context
  public void setServletContext( ServletContext servletContext ) {
     ...
  }