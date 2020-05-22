class UserBasic {

    private User user;

    public UserBasic(User user) {
        this.user = user;
    }

    public String getFirstName() {
        return user.getFirstName();
    }
    ...
}