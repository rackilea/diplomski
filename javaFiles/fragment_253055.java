class TestAddress {

    public static void main(String[] args) {
        Address a = new Address();
        a.phone="001-555-12345";  // won't compile since it's not within Address class
    }
}