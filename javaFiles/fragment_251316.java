public interface EventHappened{
        void callback(int arg1, String arg2);
}

...

ArrayList<EventHappened> eventHappenedObservers = new ArrayList<~>;

...

public void setEventHappenedObserver(EventHappened observer){
     eventHappenedObservers.add(observer);
}

...

if (eventHasHappened){
    for (EventHappened eventHappenedObserver:eventHappenedObservers){
        eventHappendedObserver.callback(event.number,event.toString());
    }
}

...