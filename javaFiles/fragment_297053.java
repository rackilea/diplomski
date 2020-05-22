public void loginPost(HttpServletRequest request){
     //After sucessfull login
     User currentUser=initializeCurrentUser();
     HttpSession session=request.getSession();
     session.setAttribute(SessionToken.NAME, currentUser);
}