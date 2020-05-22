public class StackOverFlowSampleMain {
    StackOverFlowSampleMain oomeSampleMain;
    static int x = 0;

    StackOverFlowSampleMain() {
        x++;
        System.out.println(x);
        oomeSampleMain = new StackOverFlowSampleMain(); // Here, after x is printed
    }
}