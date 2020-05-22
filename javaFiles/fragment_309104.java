public class User {
    @JsonSetter(nulls = Nulls.SKIP)
    private Integer age;

    public User() {
        this.age = 18;
    }

    ...
}