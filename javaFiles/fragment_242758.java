@Override
public void run() {
    while (true) {
        // TODO Auto-generated method stub
        try {
            while (min == 0) {
                System.out.println("Enter minutes to snooze..");
                min = scn.nextInt();
            }

            convertedToMiliSec = TimeUnit.MINUTES.toMillis(min);
            try {
                Thread.sleep(convertedToMiliSec);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

            System.out.println("Alarm Now!!!");
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
public static void main(String[] args) throws InterruptedException {
    // TODO Auto-generated method stub
    mnz.setDaemon(true);
    mnz.start();
    mnz.join();
}