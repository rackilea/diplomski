public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

      // call DAO method to get the email and password
    HashMap<String,String> map=ViewDAO.getDetails();

    //from the map you will get the  email and password.then you need to set them in the attributes and get them in your jsp

     request.setAttribute("email", map.get("email"));
      request.setAttribute("password", map.get("password"));

}