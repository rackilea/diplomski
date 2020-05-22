package de.scrum_master.app;

import java.util.Arrays;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        List<User> users = Arrays.asList(
            new User("mr_x",    "foobar"),
            new User("bruce",   "foobar"),
            new User("bruce",   "alm1GHTy"),
            new User("john",    "foobar"),
            new User("john",    "LetMe_in"),
            new User("jane",    "foobar"),
            new User("jane",    "heLL0123"),
            new User("richard", "foobar"),
            new User("richard", "dicky"),
            new User("martha",  "foobar"),
            new User("martha",  "paZZword")
        );

        for (User user : users) {
            try {
                UserDB.login(user);
                System.out.printf("%-8s -> %s%n", user.getId(), "Successful " + UserDB.getRole(user) + " login");
            } catch (Exception e) {
                System.out.printf("%-8s -> %s%n", user.getId(), e.getMessage());
            }
        }
    }
}