@TransactionAttribute(value = TransactionAttributeType.REQUIRES_NEW)
public void flush() {
    Query q = manager.createQuery("SELECT eventLog FROM EventLog AS eventLog" );
    Collection<EventLog> result = q.getResultList();
    if (result != null && result.size() > 0) {

        for (EventLog eventLogEntry : result) {
            .... update lucen index for each entry
            .......
            // remove the eventLogEntry.
            manager.remove(eventLogEntry);
        }
    }
}