class User {
    private static int counter = 0; // static! - this is class member, it's common for all instances of Users
    private int ID = counter++; // new User has its own ID number that is incremented with each creation of new instance of User class
    private String name = "user" + ID; // here is unique name of each User

    public int getID() { // convenience method to show ID number
        return ID;
    }

    public String getName() { // convenience method to show name
        return name;
    }

    public String toString() { // String representation of User
        return name;
    }
}

public class MyClass {
    public static void main(String[] args) {
        Map<Integer, String> map = new LinkedHashMap<>(); // LinkedHashMap, just to make the output clear, Users will be stored in the order of adding them to Map

        for(int i = 0; i < 5; i++) { // Here you create 5 new Users and each has its own new ID
            User user = new User();
            map.put(user.getID(), user.getName()); // just to store new Users in a Map (key is ID number, value is user's name
        }

        for(Map.Entry<Integer, String> entry : map.entrySet()) { // this loop is just to print the results contained in Map to the console
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}