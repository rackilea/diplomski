public static Result someMethod(){
    DynamicForm dynamicForm = form().bindFromRequest();

    Cache.set("df.from.original.request", dynamicForm, 60);
    return redirect(routes.Application.otherMethod());
}

public static Result otherMethod() {
    DynamicForm previousData = (DynamicForm) Cache.get("df.from.original.request");

    if (previousData == null) {
        return badRequest("No data received from previous request...");
    }

    // Use the data somehow...
    String someData = previousData.get("someField");

    // Clear cache entry, by setting null for 0 seconds
    Cache.set("df.from.original.request", null, 0);

    return ok("Previous field value was " + someData);
}