public class Globals {

public static ArrayList<User> userObjArray = new ArrayList<User>();

//Weird magic class stuff
private static Globals instance;

private Globals() {
}

public static synchronized Globals getInstance() {
    if (instance == null) {
        instance = new Globals();
    }
    return instance;
}