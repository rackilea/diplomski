public class MySingleton{
    private static final MySingleton _instance = new MySingleton();
    private MySingleton(){}
    public static MySingleton getInstance() { 
        return _instance;
    }
}