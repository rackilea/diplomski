public void doGet(HttpServletRequest request,
                HttpServletResponse response) throws ServletException, IOException {
  if(request.getHeader("User-Agent").contains("Mobi")) {
    //you're in mobile land
  } else {
    //nope, this is probably a desktop
  }
}