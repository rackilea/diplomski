@Component
public class MyHandler implements EventHandler<Event> {
    private List<Event> batchOfEvents = new LinkedList<>();

    @Override
    public void onEvent(Event Event, long sequence, boolean endOfBatch) throws Exception {
        // Add message to batch
        batchOfEvents.add(event);

        if (endOfBatch && !batchOfEvents.isEmpty()) {
            // Feed your batch to some Mongo DB dao or any other service
            someService.process(batchOfEvents);
            batchOfEvents.clear();
        }
}