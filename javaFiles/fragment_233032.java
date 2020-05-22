class MyServlet extends HttpServlet {

  private void Object sharedObject = new Object()

  protected synchronized void doGet(HttpServletRequest req, HttpServletResponse resp) {
    // method logic goes here
  }

  protected void doPost(HttpServletRequest req, HttpServletResponse resp) {

    synchronized(sharedObject) {
      // method logic goes here
    }

  }

  protected void doPut(HttpServletRequest req, HttpServletResponse resp) {

    synchronized(this) {
      // method logic goes here
    }
  }
}