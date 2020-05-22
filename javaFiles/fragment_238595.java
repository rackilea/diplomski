public class ThreadSafeLazySingleton{
   private static ThreadSafeLazySingleton instance;

  public static ThreadSafeLazySingleton getInstance(){
     synchronized(ThreadSafeLazySingleton.class){
        if(instance == null){
            instance = new ThreadSafeLazySingleton();
        }
        return instance;
     } 

}