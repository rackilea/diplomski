if (validUser) {
    System.out.println("Valid user. So, Going to another servlet /welcome.do");
    HttpSession session = request.getSession();
    //creating the User user instance
    User user = new User();
    user.setName(userName);  //assuming this is an attribute in User class
    //store it into session
    session.setAttribute("user", user);
    request.getRequestDispatcher("/welcome.do").forward(request, response);
} //rest of code...