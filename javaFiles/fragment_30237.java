@Override
public String intercept(ActionInvocation action) throws Exception {
    HttpSession session=ServletActionContext.getRequest().getSession(false);  
    if(session==null || session.getAttribute("login")==null)
    {
        System.out.println("First Inter");
        return "login";
    }
    return action.invoke();
}