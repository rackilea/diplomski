@CamundaSelector(type = "userTask", event = TaskListener.EVENTNAME_CREATE)
public class TaskCreateListener implements TaskListener {

   public TaskCreateListener(EventBus eventBus) {
     eventBus.register(this);
   }

   @Override
   public void notify(DelegateTask delegateTask) {
      ...
   }
}