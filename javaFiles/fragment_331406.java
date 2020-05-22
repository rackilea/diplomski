public class Employee {
    private String username;
    private String password;
    private String city;

    @Override
    public String toString() {
        return "username=" + username + " city=" + city;

    }

    public static void main(String[] args) {
        System.out.println(new Employee().toString());
    }
}