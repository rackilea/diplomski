import java.util.ArrayList;
import java.util.List;

/** @see http://stackoverflow.com/questions/6006323 */
public class UserMain {

    private static final List<User> users = new ArrayList<User>();

    public static void main(String[] args) {
        users.add(new User("A", new WheelStrategy()));
        users.add(new User("B", new SeaStrategy()));
        users.add(new User("C", new WheelStrategy()));
        for (User user : users) {
            user.listAllSubUsers();
        }
    }

    private static class User {

        private String name;
        private SubUsersStrategy suStrategy;

        public User(String name, SubUsersStrategy suStrategy) {
            this.name = name;
            this.suStrategy = suStrategy;
        }

        public void listAllSubUsers() {
            System.out.print(name + " manages ");
            List<User> subUsers = suStrategy.getList();
        }
    }

    private interface SubUsersStrategy {

        List<User> getList();
    }

    private static class WheelStrategy implements SubUsersStrategy {

        @Override
        public List<User> getList() {
            System.out.println("wheel users.");
            return null;
        }
    }

    private static class SeaStrategy implements SubUsersStrategy {

        @Override
        public List<User> getList() {
            System.out.println("sea users.");
            return null;
        }
    }
}