public class PauseAwareCronTrigger extends CronTrigger {
    // constructors you need go here

    @Override
    public Date getNextFireTime() {
        Date nextFireTime = super.getNextFireTime();
        if (nextFireTime.getTime() < System.currentTimeMillis()) {
            // next fire time after now
            nextFireTime = super.getFireTimeAfter(null);
            super.setNextFireTime(nextFireTime);
        }
        return nextFireTime;
    }
}