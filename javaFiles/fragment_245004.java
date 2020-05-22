// Do not create session if it doesn't exist
HttpSession session = request.getSession(false);
int loginAttempts=0;
try{
  loginAttempts = Integer.parseInt(session.getAttribute("LOGIN_ATTEMPTS").toString());
  loginAttempts++; //if code comes here then the user has already made a login attempt and therefore icrease the counter
}catch(Exception ex){
  //if error then that means that the user has never made a login attempt because the attribute was not found
  session.setAttribute("LOGIN_ATTEMPTS",1);
}