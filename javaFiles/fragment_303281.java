if(result.next()) {
    response.sendRedirect("LoginSuccessful.jsp");
}else{
    request.setAttribute("errMsg", "username and password are incorrect");
    // The following will keep you in the login page
    RequestDispatcher rd = request.getRequestDispatcher("/login.jsp");
    rd.forward(request, response); 
}