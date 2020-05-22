public class MyQueueParser
{
    @Autowired
    private TaskScheduler scheduler;

    public void parseQueue()
    {
        for (Item item: myQueue)
        {
            scheduler.schedule(() -> {
                // do the work
            }, item.getCreationTime());
        }
    }
}