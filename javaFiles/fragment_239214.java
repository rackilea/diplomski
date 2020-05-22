public class Map_Delegate {
    private static Map_Delegate instance;

    private Map_Delegate() {
         // Private constructor so nobody can create an instance of your class.
    }

    public static Map_Delegate getInstance() {
        if (instance == null) {
            instance = new Map_Delegate();
        }
        return instance;
    }

    // All the rest of your code can go here.
}