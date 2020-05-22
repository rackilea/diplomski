public Event loadEvent(String id) {
    PersistenceManager pm = PMF.get().getPersistenceManager();
    try {
        Event event = pm.getObjectById(Event.class, Long.parseLong(id));
        // And load entries
        for (Entry entry : event.getEntries()) {
            entry.amounts.size();
        }
        return event;
    } catch (NumberFormatException e) {
        return null;
    } finally {
        pm.close();
    }
}