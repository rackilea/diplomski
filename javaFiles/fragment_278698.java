public static Result myMethod() throws IOException {
    ....
    DynamicForm requestData = Form.form().bindFromRequest();

    if (requestData.get("update")!=null) {
        // do the update
    } else if (requestData.get("createNew")!=null) {
        // create a new one
    }
}