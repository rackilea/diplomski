public User getUser(String userid) {
    User user;
    try {
        // some code to get User
    } catch (InterruptedException e) {
        throw SomeHandlerInProject.buildCustomErr();
    }
    return user;
}

class SomeHandlerInProject {
    public static CustomException buildCustomErr() {
        return new CustomException();
    }
}