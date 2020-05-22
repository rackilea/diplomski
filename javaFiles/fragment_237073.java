MyEjb {
   @Stateless
   public class TimerBean implements TimerRemote {

    @Resource
    TimerService service;

    @Override
    public void startTimer() {
        Timer timer = service.createTimer(1000,  1000, null);
        System.out.println("Timers set");
    }

    @Timeout
    public void handleTimeout(Timer timer) {
        System.out.println("Handle timeout event here...");
    }
}