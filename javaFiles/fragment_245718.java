protected void processRequest(HttpServletRequest request, ...) {

  // defining variables...
  DbBean db = null;
  boolean commit = false;

  try {
    db = new DbBean();
  } catch (SomeException e) {
    commit = false;
  } finally{
    db.release(commit); /* close database connection => java.sql.Connection#close() */
  }

...
}