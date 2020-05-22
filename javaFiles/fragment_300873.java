class OtherProgram {

    public static void main(String[] arg) {
        for (int i = 0; i < 5; i++)
            new Thread() {
                public void run() {
                    System.out.println("Starting...");
                    try {
                        sleep(5000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("Stopping...");
                }
            }.start();
    }
}