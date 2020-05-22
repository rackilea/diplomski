public class MyUserDetails extends User {
    private MyUser myUser;
    public MyUserDetails(..., MyUser myUser) {
        super(...);
        this.myUser = myUser;
    }
    public MyUser getMyUser() {
        return myUser;
    }
    ...
}