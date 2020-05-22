package sandbox.package2;

import java.util.ArrayList;
import java.util.List;
import sandbox.pakcage1.Player;

public class UserBuilder {
    public static List<Player> getUsers() {
        List<Player> users = new ArrayList<>();

        users.add(new User("Joe", "1"));
        users.add(new User("Bob", "2"));

        return users;
    }
}