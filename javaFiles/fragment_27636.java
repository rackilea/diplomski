@Service ( objectName = "OurApp:SchedulerMBean=SchedulerMBean", 
  xmbean="resource:path/to/SchedulerMBean.xml")
public class SchedulerMBean {
   public void start() { ... }
   public void initScheduler(String schedulerName) { ... }
}