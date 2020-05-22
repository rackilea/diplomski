public class test {

    public static void main(String[] args) throws InterruptedException {
        boolean delay = true;
        int counter = 0;
        while (true) {
            if(delay == true) {
                Thread.sleep(1000);//time in millisecond, here 1000 = 1second
                counter++;
                System.out.println("counter is now: " + counter);
            }
            if(delay == false) {
                break;
            }
            if(counter == 10) {
                delay = false;
            }
        }
        System.out.println("Done");
    }
}