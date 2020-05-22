for(Enumeration e = list.items(EventList.STARTING, startDate, endDate, false); e.hasMoreElements; ) {
    Event event = (Event)e.nextElement();
    if (sholdBeChanged()) {
        Event event2 = list.createEvent();
        // initialize fields of event2. Probably copy them from event
        list.removeEvent(event);
        break;
    }
}