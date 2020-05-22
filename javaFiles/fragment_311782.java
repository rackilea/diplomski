class UserObjectBuilder {
    private int id;
    private String name;
    private String email;

    UserObjectBuilder withId(int id) {
        this.id = id;
        return this;
    }

    UserObjectBuilder withName(String name) {
        this.name = name;
        return this;
    }

    UserObjectBuilder withEmail(String email) {
        this.email = email;
        return this;
    }

    User build() {
        return new User(id, name, email);
    }
}