interface EventConsumer {
    void respondToEvent(Event event);
}

class ClickEventConsumer implements EventConsumer {
   public void respondToEvent(Event event){
     ClickEvent ce = (ClickEvent)event;
     //...
   }
}

class EventHub {
  private HashMap<Class<? extends Event>, HashSet<EventConsumer>> subscriptions;

  public void fireEvent(Event event) {
    HashSet<EventConsumer> consumers = subscriptions.get(event.getClass());
    if (consumers != null){
      for (EventConsumer ec : consumers){
        ec.respondToEvent(event);
      }
    }
  }

  public void subscribeToEvent(Class<? extends Event> clazz, EventConsumer consumer) {
    HashSet<EventConsumer> consumers = subscriptions.get(clazz);
    if (consumers == null){
      consumers = new HashSet<EventConsumer>();
      subscriptions.put(clazz, consumers);
    }
    consumers.add(consumer);
  }
}