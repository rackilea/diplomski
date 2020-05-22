public String getEventById(List<Event> eventList, String id) {
    for (Event event : eventList) {
        if (event.getId().equals(id)) {
            return event.getEvent();
        }
    }
    return null;
}