public class EventClassCreator {
    private Map<String, List<String>> subscriptions;

    public EventClassCreator() {
        subscriptions = new HashMap<String,Set<String>>();
    }

    public void addSubscription(String event, String class) {
        if(subscriptions.containsKey(event))
            subscriptions.get(event).add(class);
        else {
            Set<String> subscriptionsForEvent = new HashSet<String>();
            subscriptionsForEvent.add(class);
            subscriptions.put(event, subscriptionsForEvent);
        }
    }

    //You just need to make an event that loops over the list of classes, 
    //checks a subscription and instantiates a class if it is in the 
    //proper list.
}