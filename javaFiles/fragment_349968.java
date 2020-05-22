public class User {
    private int a;

    public User withA(int a) {
        return this.a == a ? this : new User(a);
    }

    public User(int a) {
        this.a = a;
    }

    public User() {
    }
}