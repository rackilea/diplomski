public static Result save() {
    DynamicForm df = form().bindFromRequest();

    String value = df.get("video");
    if (value == null || value.trim().equals(""))
        return badRequest("Video param was not sent");

    // do something with the value

    return ok(value);
}