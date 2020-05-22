class Person {
    @OneToOne(cascade=CascadeType.ALL)
    private Address address;


class Address {
    @OneToOne(mappedBy=”address”)
    private Person person