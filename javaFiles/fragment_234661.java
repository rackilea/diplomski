Thread t2 = new Thread(new Runnable() {
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(i + " runnable thread...");
        }
    }
});