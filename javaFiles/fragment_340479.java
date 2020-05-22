@Stateless
public class AutomaticResponseSender {

    private static final Integer _5_MINS = 300000;

    @Resource
    private TimerService timerService;

    public void waitFiveMinutes() {
        Timer nextTimer = timerService.createSingleActionTimer(_5_MINS, null);
    }

    @Timeout
    public void autoRespondForNotAnswered() {
          // here send an auto response
    }

    public void cancel() {
        timerService.cancel();
    }
}