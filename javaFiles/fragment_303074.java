import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<User> oldUsers = new ArrayList<User>();
        List<User> newUsers = new ArrayList<User>();
        List<User> intersect;

        oldUsers.addAll(Arrays.asList(
            new User("Bob", "Smith", 30),
            new User("Tom", "Jones", 42),
            new User("Robert", "Brown", 51),
            new User("James", "Jones", 28)
        ));

        newUsers.addAll(Arrays.asList(
            new User("Robert", "Brown", 51), // Same
            new User("Bob", "Smith", 30),    // Same
            new User("Tom", "Jones", 21),
            new User("James", "Hendrix", 28)
        ));

        intersect = intersection(oldUsers, newUsers);

        System.out.printf("Number of identical values: %d%n%s%n",
                intersect.size(), "------------------------------");
        for (User user : intersect) {
            System.out.printf("- %s%n", user);
        }
    }

    // http://stackoverflow.com/a/5283123/1762224
    public static <T> List<T> intersection(List<T> list1, List<T> list2) {
        List<T> list = new ArrayList<T>();
        for (T t : list1) {
            if (list2.contains(t)) {
                list.add(t);
            }
        }
        return list;
    }
}