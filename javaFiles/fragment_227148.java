class MyProcess extends Thread {
    public void run() {
        System.out.println("MyProcess starts");
        for (int i = 0; i < 5; i++) {
            try {
                System.out.println("MyProcess sleeps");
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("MyProcess finishes");
    }
}