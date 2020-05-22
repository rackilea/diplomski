public class Test extends TimerTask{

public static void main(String[] args) {
  Test task = new Test();
  Timer timer = new Timer();
  Calendar today = Calendar.getInstance();
  today.set(Calendar.HOUR_OF_DAY, 13);
  today.set(Calendar.MINUTE, 47);
  today.set(Calendar.SECOND, 0);
  timer.schedule(task, today.getTime(), TimeUnit.MILLISECONDS.convert(1, TimeUnit.DAYS));
}

 @Override
public void run() {
 System.out.println("Running Scheduled Task...!!!");
}
}