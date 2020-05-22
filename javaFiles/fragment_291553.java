public class Singleton {
    private Singleton instance;

    private Singleton(){

    }

    public static Singleton getSingleton(){
        return instance;
    }

}