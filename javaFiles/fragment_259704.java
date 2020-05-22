public class EventsRepository implements IModelLayer<ICallback<EventBrite>>{
    @Override
    public void getEvents(ICallback<EventBrite> resultEvents) {
            WebEventsDataSource.getInstance().getEvents(resultEvents);
    }
}