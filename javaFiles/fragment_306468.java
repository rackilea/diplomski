public static Singleton getInstance() {
    if (instance == null) {
        synchronized(Singleton.class) {      
            Singleton inst = instance;         
            if (inst == null) {
                synchronized(Singleton.class) {  
                    instance = new Singleton();               
                }
            }
        }
    }
    return instance;
}