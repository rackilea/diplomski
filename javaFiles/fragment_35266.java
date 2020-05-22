package hello;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Component;

@Component
public class ScheduledTasks {

    @Autowired
    private TaskScheduler taskScheduler;

    @Autowired
    private CronConfig cronConfig;

    @Autowired
    private MyTask myTask;

    private static final Logger log = LoggerFactory.getLogger(ScheduledTasks.class);

    public void scheduleAllCrons() {

        cronConfig.getSchedules().forEach( cron -> taskScheduler.schedule(myTask, new CronTrigger(cron)) );
    }
}