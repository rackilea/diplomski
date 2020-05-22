public class Company {
    ...
    private final String address; // 1
    private final String email;

    public Company(String n, int a, String address, String email) { // 2
        ...
        this.address = address;
        this.email = email;
    }

    public static void main(String[] args) {
        ...
        comp.add(new Company("Charles", 25, "street", "charles@gmail.com")); // 3
    }

}