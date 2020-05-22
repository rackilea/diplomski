public class DCLLazySingleton{
  private static volatile DCLLazySingleton instance;

  public static DCLLazySingleton getInstace(){
     if(instance == null){
        synchronized(DCLLazySingleton.class){
            if(instance == null)
                instance=new DCLLazySingleton();
        }
     } 
     return instance;
}