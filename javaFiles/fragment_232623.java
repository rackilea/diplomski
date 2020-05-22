public static Result someMethod(){
    DynamicForm df = form().bindFromRequest();

    return redirect(routes.Application.otherMethod(df.get("action"), df.get("id")));
}

public static Result otherMethod(String action, Long id) {
    return ok("The ID for " + action +" action was" + id);
}