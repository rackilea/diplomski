@Stateless
    public class TimerUtilityBean {

    @Resource
    TimerService timerService;

     public void createTimer(String sec, String min, String hour){

        ScheduleExpression expression = new ScheduleExpression();
        expression.second(sec).minute(min).hour(hour);
        timerService.createCalendarTimer(expression);
     }

     public void cancelTimer(String timerInfo){

      if (timerService.getTimers() != null) {

           for (Timer timer : timerService.getTimers()) 
               if (timer.getInfo().equals(timerInfo))
                   timer.cancel();
       }
     }

     @Timeout
     public void execute(Timer timer){
        System.out.println("Invoked: " + System.currentTimeMillis());
     }

     public void reinitializeTimer(String sec, String min, String hour, String timerInfo){
        cancelTimer(timerInfo);
        createTimer(sec, min, hour);
     }
}