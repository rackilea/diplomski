public class Singleton  {    
    private static class SingletonHolder {    
        public static final Singleton instance = new Singleton();
    }    

    public static Singleton getInstance() {    
        return SingletonHolder.instance;    
    }    
}