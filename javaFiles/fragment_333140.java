public class DefaultGameEventHandler<I extends GameEvent<TYPE, ATT>, TYPE extends EventType, ATT extends  AttributeType> implements GameEventHandler<I, TYPE, ATT>{ 

    @Override
    public void handleEvent(GameEvent<TYPE, ATT>... e) {
        //...
    }
    @Override
    public void registerListener(GameEventListener<I> listener, TYPE... type) {
        //...
    }
    @Override
    public void unregisterListener(GameEventListener<I>... listener) {
        //...
    }
    @Override
    public void unregisterAllListener() {
        //...
    }
    @Override
    public void unregisterAllListener(I... type) {
        //...
    }
    @Override
    public void processEvents() {
        //...
    }
    @Override
    public void processEvents(int maxTimeInMS) {
        //...
    }
}