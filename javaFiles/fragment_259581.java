public User getUser() {
    return new
            User.UserBuilder("Jhon", "Doe")
            .age(30)
            .phone("1234567")
            .address("Fake address 1234")
            .build();
}