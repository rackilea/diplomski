public class Test{

  private ArrayList<String> arr = new ArrayList<String>();

  private static Test uniqueInstance = new Test();

  private Test{}      // Make constructor Private

  public static Test getInstance(){

    return uniqueInstance;


   }

}