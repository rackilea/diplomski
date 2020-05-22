import java.util.ArrayList;
import java.util.List;

public class main {

    private static List<User> users = new ArrayList<User>();

    public static void main(String[] args) {
        // Creates the users
        User user1 = new User("1", "John", "Addams", "john@mail.com", "j123", "Math", new ArrayList<String>());
        User user2 = new User("2", "Mary", "Stall", "mary@mail.com", "m123", "Math", new ArrayList<String>());
        User user3 = new User("3", "Kurt", "Metten", "kurt@mail.com", "k123", "Math", new ArrayList<String>());

        // Adds the users to the array
        users.add(user1);
        users.add(user2);
        users.add(user3);

        System.out.println(isExistingEmail("john@mail.com")); // True
        System.out.println(isExistingEmail("some mail@mail.com")); // False
    }

    private static boolean isExistingEmail(String email) {
        // Iterates all the users
        for (User user: users) {
            // Checks if the user email is equal to the email parameter
            if (user.email.equals(email)) {
                return true;
            }
        }
        return false;
    }
}