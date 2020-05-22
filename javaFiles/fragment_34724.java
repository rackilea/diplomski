protected void service(HttpServletRequest request,
      HttpServletResponse response) throws IOException {
  try {

    // servlet code here, e.g. super.service(request, response);

  } catch (Exception e) {
    // log the error with a timestamp, show the timestamp to the user
    long now = System.currentTimeMillis();
    log("Exception " + now, e);
    response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
    response.getWriter().println("Guru meditation: " + now);
  }
}