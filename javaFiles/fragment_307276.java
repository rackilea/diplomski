public static class Singleton{
    private final static Singleton instance;

    private Singleton(){}

    public static Singleton getInstance(){
        if(instance == null)
            instance = new Singleton();
        return instance;
    }


}