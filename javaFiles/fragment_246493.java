@Configuration
// This is important!
@EnableScheduling
public class Configuration{
 // TODO Change to 0 0 0/2 1/1 * ? *
 @Scheduled(cron = "0 15 10 15 * ?")
 public void scheduleTaskUsingCronExpression() {

    long now = System.currentTimeMillis() / 1000;
     System.out.println(
        "schedule tasks using cron jobs - " + now);
  }