HttpSession httpSession = request.getSession(false); 
//False because we do not want it to create a new session if it does not exist.
User user = null;
if(httpSession != null){
    user = (User) httpSession.getAttribute("user");
}

if(user!=null){
    // Do stuff here
}