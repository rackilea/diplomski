public class Test {   
    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 100; i++) {
            System.out.print("\rThinking... " + i);
            System.out.flush();
            Thread.sleep(100);
        }
    }
}