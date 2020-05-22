class Starter implements Runnable {
    boolean stopConditionMet = false;
    public void run() {
        BatteryAnimation.start();
        try {
         while (!stopConditionMet) { Thread.sleep(500); } 
        } catch (InterruptedException e) {}
         BatteryAnimation.stop();

    }
    public void stop() { stopConditionMet=true; }

}