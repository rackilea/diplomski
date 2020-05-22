private static class CustomRunnable implements Runnable{
    @Override
    public void run() {
        boolean waiting = true;

        while(waiting){
            try {
                Thread.sleep(30000);
                waiting = false;
                // went 30 seconds with no interrupt - go to sleep mode
            } catch (InterruptedException e) {
                waiting = true;
                // we were interrupted by mouse movement - restart loop
            }
        }
    }
}