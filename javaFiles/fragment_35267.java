package hello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.concurrent.ConcurrentTaskScheduler;

@SpringBootApplication
@EnableScheduling
@EnableAsync
public class Application {

    @Bean
    public TaskScheduler taskScheduler() {
        return new ConcurrentTaskScheduler();
    }


    public static void main(String[] args) throws Exception {
        ApplicationContext ctx = SpringApplication.run(Application.class);

        ScheduledTasks scheduledTasks = ctx.getBean(ScheduledTasks.class);

        scheduledTasks.scheduleAllCrons();
    }
}