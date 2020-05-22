public class UserBuilder { // This could be made a nested class of User
    private int age = -1;
    private String name;
    private String surname;
    private Color hairColor;

    public UserBuilder age(int age) {
        this.age = age;
        return this;
    }
    // ... other properties ...
    public User build() {
        // Or return new User(this)
        return new User(age, name, surname, hairColor);
    }
}