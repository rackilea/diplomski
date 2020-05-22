public class loops {
    public static void main(String args[]) throws InterruptedException {
        int countdown = 1;
        while (countdown < 10){
            System.out.println(countdown);
            ++countdown;
            Thread.sleep(1000);
        }
    }
}