public class MainClass {
    Class2 class2 = new Thread(new Class2());
    class2.start();
    class2.join();
    // Class2.value will == 10 here
}