public interface Trigger {
    TriggerResultInterface execute(TriggerEventHelper eventHelper);
}

public class MetaTrigger implements Trigger {
    @Override
    TriggerResultInterface execute(TriggerEventHelper eventHelper) {
        // do meta trigger work here
    }
}

public class DataTrigger implements Trigger {
    @Override
    TriggerResultInterface execute(TriggerEventHelper eventHelper) {
        // do data trigger work here
    }
}

// ...

public TriggerResultInterface executeTriggerJob(TriggerEventHelper eventHelper) {
    eventHelper.getTrigger().execute(eventHelper);
}