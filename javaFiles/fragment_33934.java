Runnable runner = new Runnable() {
    @Override
    public void run() {
        boolean cont = true;
        while (cont) {
           cont = getResponseFromServer();
           try {
              Thread.sleep(5000);
           } catch (Exception e) {
              // we don't care about this, it just means this time it didn't sleep
           }
        }
    }
}
new Thread(runner).start();