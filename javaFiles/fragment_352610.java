public String intercept(ActionInvocation ai) throws Exception {
    // TODO Auto-generated method stub
    System.out.println("inside the interceptor()......new");
    Map session = ai.getInvocationContext().getSession();
    if ((session.get("user") != null) || 
        ((session.get("user") == null) && (ai.getAction() instanceof LoginAction)) {
        return ai.invoke();
    } else {
        return "login";
    }
}