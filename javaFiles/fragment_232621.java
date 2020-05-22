public static Result someMethod(){
    DynamicForm dynamicForm = form().bindFromRequest();
    return otherMethod(dynamicForm);
}

public static Result otherMethod(DynamicForm dataFromPrevRequest) {
    String someField = dataFromPrevRequest.get("some_field");
    Logger.info("field from request is: " + someField);
    return ok("Other method's Result");
}