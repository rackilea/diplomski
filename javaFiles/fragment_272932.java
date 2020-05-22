public class MultiThreading_2 {
    static volatile boolean flag = false;
    static volatile String word = "I";

    public static void main(String[] args) throws InterruptedException {

        MultiThreading_2 m = new MultiThreading_2();

        Runnable a = new Runnable() {

            public void run() {

                for (int i = 0; i < 3; i++) {
                    synchronized (m) {
                        if (word.equals("I")) {
                            System.out.print("I ");
                            word = "LOVE";

                            m.notify();
                            try {
                                m.wait();
                            } catch (InterruptedException e) {
                                // TODO Auto-generated catch block
                                e.printStackTrace();
                            }
                        } else {
                            i--;
                        }

                    }

                }
            }

        };

        Runnable b = new Runnable() {

            public void run() {

                for (int i = 0; i < 3; i++) {
                    synchronized (m) {
                        if (word.equals("LOVE")) {
                            System.out.print("LOVE ");
                            word = "WORLD";
                            m.notify();
                            try {
                                m.wait();
                            } catch (InterruptedException e) {
                                // TODO Auto-generated catch block
                                e.printStackTrace();
                            }

                        } else {
                            i--;
                        }

                    }

                }
            }

        };

        Runnable c = new Runnable() {

            public void run() {

                for (int i = 0; i < 3; i++) {
                    synchronized (m) {
                        if (word.equals("WORLD")) {
                            System.out.println("WORLD ");
                            word = "I";
                            m.notify();
                            try {
                                m.wait();
                            } catch (InterruptedException e) {
                                // TODO Auto-generated catch block
                                e.printStackTrace();
                            }

                        } else {
                            i--;
                        }
                    }

                }

            }

        };

        new Thread(a).start();
        Thread.sleep(100);
        new Thread(b).start();
        Thread.sleep(100);
        new Thread(c).start();

    }

}