User user = ... //use your UserManager or something else to get the user
if (<valid user>) {
    //store the user object in session
    request.getSession().setAttribute("user", user);
}
//forward to the next view...