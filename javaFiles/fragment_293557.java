import java.util.Calendar;
import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.Timeout;
import javax.ejb.Timer;
import javax.ejb.TimerConfig;
import javax.ejb.TimerService;

@Stateless
public class FirstTimer {

    @Resource
    private TimerService timerService;

    @EJB
    private Ejb2 ejb2;

    @EJB
    private Ejb1 ejb1;

    /* 
     * Call this from somewhere to start the timer.
     * Use the returned Timer object to cancel it if needed.
     */
    public Timer scheduleTask() {
        final Calendar start = ejb2.getStartDate();
        final long period = ejb2.getPeriodInMillisecs();
        return timerService.createIntervalTimer(start.getTime(), period, new TimerConfig(null, false));
    }

    @Timeout
    public void handleTimeout() {
        ejb1.method1();
        ejb1.method2();
    }

}