public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
    signInForm connect = new signInForm();
    User user = connect.validateSignIn(request);
    HttpSession session = request.getSession();

    if (user != null) {
       // request.setAttribute("connect", connect); //what the hell is connect supposed to be here? 
        session.setAttribute("sessionUser", user);
       // this.getServletContext().getRequestDispatcher("/restrict_client/client.jsp").forward(request, response); //you do not do this in ajax requests.
    }else{
    //request.setAttribute("connect", connect);
     //this.getServletContext().getRequestDispatcher("/signIn.jsp").forward(request, response);
    }
    response.setContentType("text/plain");  // Set content type 
    response.setCharacterEncoding("UTF-8"); 
    response.getWriter().write("hello world");       // Write response body.

}