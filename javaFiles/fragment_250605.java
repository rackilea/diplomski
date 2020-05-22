public class UserPrinter {
    private final String name;

    public UserPrinter(String name) {
        this.name;
    }

    public static void staticPrintUser(User user) {
        // Assuming you add a User.getName() method
        System.out.println("staticPrintUser: " + user.getName());
    }

    public void instancePrintUser(User user) {
        System.out.println("instancePrintUser (instance " + name + "): "
            + user.getName());
    }
}