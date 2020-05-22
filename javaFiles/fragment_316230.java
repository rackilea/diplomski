package misc.user;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Michael
 * Creation date 8/5/2017.
 * @link https://stackoverflow.com/questions/45524768/java-unit-testing-help-for-loop
 */
public class UserTest {

    private static List<User> users;

    @BeforeClass
    public static void setUp() {
        users = new ArrayList<>();
        users.add(new User("FooBar", "myPassword"));
        users.add(new User("GeorgeBush", "exPrez"));
        users.add(new User("weatherBoy", "cloudy"));
    }

    @Test
    public void testLogin_Success() {
        // setup
        String username = "weatherBoy";
        String password = "cloudy";
        // exercise
        boolean isValidUser = users.contains(new User(username, password));
        // assert
        Assert.assertTrue(isValidUser);
    }

    @Test
    public void testLogin_Failure() {
        // setup
        String username = "noSuchUser";
        String password = "does not matter";
        // exercise
        boolean isValidUser = users.contains(new User(username, password));
        // assert
        Assert.assertFalse(isValidUser);
    }
}