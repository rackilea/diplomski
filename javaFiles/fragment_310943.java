public class ThreadTest {

  public static void Main(string[] args) 
  {
    Task task = new Task(() => ... // Code to run here);
    task.Start();
  }
}