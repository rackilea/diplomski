public class App12 {

    Semaphore sem1 = new Semaphore(1);
    Semaphore sem2 = new Semaphore(0);
    Semaphore sem3 = new Semaphore(0);

    int count = 0;

    public void inc() throws InterruptedException {

        while (true) {

            if (Thread.currentThread().getId() == 10) {
                sem1.acquire();
                if (count != 50) {
                    count++;
                    System.out.println("Thread " + Thread.currentThread().getId() + " has incremented " + count);
                    sem2.release();
                } else {
                    sem2.release();
                    return;
                }
            }

            if (Thread.currentThread().getId() == 11) {
                sem2.acquire();
                if (count != 50) {
                    count++;
                    System.out.println("Thread " + Thread.currentThread().getId() + " has incremented " + count);
                    sem3.release();
                } else {
                    sem3.release();
                    return;
                }

            }

            if (Thread.currentThread().getId() == 12) {
                sem3.acquire();
                if (count != 50) {
                    count++;
                    System.out.println("Thread " + Thread.currentThread().getId() + " has incremented " + count);
                    sem1.release();
                } else {
                    sem1.release();
                    return;
                }
            }

        }
    }

    public static void main(String[] args) {

        App12 ap = new App12();
        for (int i = 0; i < 3; i++) {
            Thread th1 = new Thread(new Runnable() {
                public void run() {
                    try {
                        ap.inc();
                        // dec3();
                        System.out.println("Exist ");
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }

                }
            });
            th1.start();
        }
    }
}