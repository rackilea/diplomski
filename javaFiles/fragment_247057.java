@Post
public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  String pathInfo = request.getPathInfo();
  String[] pathElements = pathInfo.split("/"); 
  // get last item (or whatever one you need)
  String dbRef = pathInfo[pathInfo.lenth -1];
  // check input. User could have tampered url

  // do your stuff with dbRef
}