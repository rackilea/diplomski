request.isRequestedSessionIdValid()

  or

HttpSession sess = request.getSession(false);
if (sess != null) {
   // it's valid
}