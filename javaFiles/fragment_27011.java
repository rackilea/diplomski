public class CustomTrigger extends Trigger<GenericObject, GlobalWindow> {

private final ReducingStateDescriptor<Long> stateDesc = new ReducingStateDescriptor<>("count", new Sum(), LongSerializer.INSTANCE);

@Override
public TriggerResult onElement(ImpactEventObject impactEventObject, long l, GlobalWindow globalWindow, TriggerContext triggerContext) throws Exception {
    ReducingState<Long> count = triggerContext.getPartitionedState(stateDesc);
    count.add(1L);

    if (count.get() == 1) {
        triggerContext.registerProcessingTimeTimer(
            triggerContext.getCurrentProcessingTime() + 20000);
    }
    return TriggerResult.CONTINUE;
}

@Override
public TriggerResult onProcessingTime(long l, GlobalWindow globalWindow, TriggerContext triggerContext) throws Exception {
    return TriggerResult.FIRE;
}

@Override
public TriggerResult onEventTime(long l, GlobalWindow globalWindow, TriggerContext triggerContext) throws Exception {
    return null;
}

@Override
public void clear(GlobalWindow globalWindow, TriggerContext triggerContext) throws Exception {
    triggerContext.deleteProcessingTimeTimer(triggerContext.getCurrentProcessingTime());
}

private static class Sum implements ReduceFunction<Long> {
    private static final long serialVersionUID = 1L;
    @Override
    public Long reduce(Long value1, Long value2) throws Exception {
        return value1 + value2;
    }

}
}