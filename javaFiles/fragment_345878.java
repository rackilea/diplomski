Form<User> userForm = Form.form(User.class).bindFromRequest();
if(userForm.hasErrors()) {
    return badRequest();
} else {
    User user = userForm.get();
    // whatever
    return ok();
}