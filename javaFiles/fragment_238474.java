public class TimerTaskInvoker implements SmartLifecycle{
@override
public void start(){
  timer.scheduleAtFixedRate(timerTask);
  }
}