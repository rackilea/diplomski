public String intercept(ActionInvocation invocation) throws Exception {
    final ActionContext context = invocation.getInvocationContext(); 
    Map<String, Object> parameters = context.getParameters();
    String[] values = (String[]) parameters.get("csrfPreventionSalt");
    String salt = values[0];
    ...