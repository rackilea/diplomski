public static void register(@Required String name) {
    if(User.findByName(name)!=null) {
        Validation.addError("name", "this name is not available");
    }
    if (validation.hasErrors()) {
        validation.keep();
        params.flash();
        flash.error("Please correct the form data.");
        signup(); // whatever your GET action was
    }

    User user = new User(name);
    login(); // whatever your success action is
}