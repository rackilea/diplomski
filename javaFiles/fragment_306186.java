@Singleton 
@Startup
@DependsOn("TimerUtilityBean") 
public class EBlastScheduler {

@EJB
TimerUtilityBean timerBean;

@PostConstruct
 public void initialize(){
  timerBean.cancelTimer("EBlastScheduler");
  timerBean.createTimer("*/1", "*", "*");
 }
}