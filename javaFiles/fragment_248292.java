public class ScheduleService extends Service {

  @Override
  public int onStartCommand(Intent intent, int flags, int startId) {

      Timer timer = new Timer();
      timer.schedule(task,1,10000);
      return Service.START_STICKY;
  }

  TimerTask task=  new TimerTask() {
    @Override
    public void run() {
      //do your task here.
    }
  };

  @Nullable
  @Override
  public IBinder onBind(Intent intent) {
      return null;
  }
}