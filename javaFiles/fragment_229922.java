public class MyController {
@RenderMapping
    public String defaultView() {
        try {
            String cron = "0 0 11 1/1 * ? *";
            String description = "";
            String destinationName = DestinationNames.SCHEDULER_DISPATCH;
            int exceptionsMaxSize = 0;
            String portletId = "portlet_id";

            Message message = new Message();
            message.put(SchedulerEngine.MESSAGE_LISTENER_CLASS_NAME, Scheduler.class.getName());            
            message.put(SchedulerEngine.PORTLET_ID, portletId);

            Trigger trigger = new CronTrigger(Scheduler.class.getName(), Scheduler.class.getName(), cron);
            SchedulerEngineHelperUtil.schedule(trigger, StorageType.PERSISTED, description, destinationName, message, exceptionsMaxSize);

        } catch (SchedulerException e) {
              e.printStackTrace();
        }
        return "view";
    }
}