import java.util.LinkedHashMap;
import java.util.Map;

public class Main {
    public static void main(String... args) {
        UserDB userDB = new UserDB();
        // add 1000,000 users
        for (int i = 0; i < 1000000; i++)
            userDB.addUser(
                    new Profile(i,
                            "user+i",
                            (short) (18 + i % 90),
                            i % 2 == 0 ? Profile.Sex.Male : Profile.Sex.Female,
                            "here", "mode"));
        // lookup a users and add a chat session.
        long start = System.nanoTime();

        int operations = 0;
        for(int i=0;i<userDB.profileCount();i+=2) {
            Profile p0 = userDB.getProfileByNumber(i);
            operations++;
            Profile p1 = userDB.getProfileByNumber(i+1);
            operations++;
            userDB.chatsTo(i, i+1);
            operations++;
        }
        for(int i=0;i<userDB.profileCount();i+=2) {
            userDB.endChat(i);
            operations++;
        }
        long time = System.nanoTime() -start;
        System.out.printf("Average lookup and update time per operation was %d ns%n", time/operations);
    }
}

class UserDB {
    private final Map<Long, Profile> profileMap = new LinkedHashMap<Long, Profile>();
    private final Map<Long, Long> chatsWith = new LinkedHashMap<Long, Long>();

    public void addUser(Profile profile) {
        profileMap.put(profile.number, profile);
    }

    public Profile getProfileByNumber(long number) {
        return profileMap.get(number);
    }

    public void chatsTo(long number1, long number2) {
        chatsWith.put(number1, number2);
        chatsWith.put(number2, number1);
    }

    public void endChat(long number) {
        Long other = chatsWith.get(number);
        if (other == null) return;
        Long number2 = chatsWith.get(other);
        if (number2 != null && number2 == number)
            chatsWith.remove(other);
    }

    public int profileCount() {
        return profileMap.size();
    }
}

class Profile {
    final long number;
    final String name;
    final short age;
    final Sex sex;
    final String location;
    final String aslmode;

    Profile(long number, String name, short age, Sex sex, String location, String aslmode) {
        this.number = number;
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.location = location;
        this.aslmode = aslmode;
    }

    enum Sex {Male, Female}

}