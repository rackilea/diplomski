class Person {
    private String name;

    @JsonUnwrapped
    private Address address;

    // getters, setters, toString
}
class Address {
    private String street;
    private String city;

    // getters, setters, toString
}