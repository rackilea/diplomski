public static Result deleteUser(Long id) {
    User user = User.find.byId(id);
    if(user == null) {
        return notFound();
    } else {
        user.delete();
        return ok();
    }
}