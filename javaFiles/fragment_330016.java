@Test
public void test() throws InterruptedException {

    new Thread(()->{
        while(true){
            System.out.println("printing something");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }
    }).start();

    Thread.sleep(500);
    synchronized (System.out){
        System.out.println("changin system out");
        Thread.sleep(2000);
        System.out.println("finished with sysout");
    }
    Thread.sleep(2000);
}