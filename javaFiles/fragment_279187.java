public static void main(String[] args) throws InterruptedException{
    for (int x = 0; x < 100; x++) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                Counter m = new Counter("Name");
            }
        }).start();
    }
    Thread.sleep(1000);//put a delay
    System.out.println(MODULES.size());
}