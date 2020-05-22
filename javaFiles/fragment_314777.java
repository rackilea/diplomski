import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class UsersTest {

    public static void main(String[] args) throws ParseException {
        String record =  "Mark.Labinson/11051985/Chicago Michael.Louis/25081972/NewYork Gabriel.Vitton/05051988/SanDiego";
        String[] users = record.split("\\s+");

        List<User> userList = new ArrayList<User>();
        for(String user : users) {
            userList.add(new User(user.split("\\/|\\.")));
        }
        System.out.println("userList : "+ userList);
    }
}