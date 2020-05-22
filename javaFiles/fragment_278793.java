public class Test{

   public static Test uniqueInstance = new Test();

   private Test(){}

   public static Test getInstance(){

      return uniqueInstance;       

      // No matter what but always u will get the same instance.

   }

}