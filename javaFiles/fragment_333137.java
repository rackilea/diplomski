public interface GameEventHandler<I extends GameEvent<TYPE, ATT>, TYPE extends EventType, ATT extends  AttributeType> {

    public void handleEvent(final GameEvent<TYPE, ATT>... e);
    public void registerListener(final GameEventListener<I> listener, final TYPE... type);

    public void unregisterListener(final GameEventListener<I>... listener);

    public void unregisterAllListener();
    public void unregisterAllListener(final I... type);

    public void processEvents();
    public void processEvents(final int maxTimeInMS);

}