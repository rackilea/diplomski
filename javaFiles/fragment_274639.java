if (handler instanceof HandlerMethod) {
    HandlerMethod maControl = (HandlerMethod) handler;  
    Method pmrResolver = (Method) maControl.getMethod();  
    String methodName = pmrResolver.getName(); 
    // ...
}