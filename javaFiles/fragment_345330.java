public String signIn(SignIn signIn) {
    ...
    if(!"skroob@spaceballs.example.com".equals(email) || !"827ccb0eea8a706c4c34a16891f84e7b".equals(hashedPassword))
        failReason = "Login failed; incorrect email or password.";
    else {
        RequestFactoryServlet.getThreadLocalRequest().getSession().setAttribute("auth", signIn);
    }
    return failReason;
}

public void signOut(SignOut signOut) {
    RequestFactoryServlet.getThreadLocalRequest().getSession().removeAttribute("auth");
    return;
}