public class Singleton {
    private static Singleton instance;

    private Singleton(){

    }

    public static Singleton getSingleton(){
        return instance;
    }

}