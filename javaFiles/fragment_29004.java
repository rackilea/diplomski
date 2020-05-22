@Transactional
public void executeTransactionCode(final Long id) {
    MyRollbackEvent myRollbackEvent = ... create the event with the necessary data ...
    applicationEventPublisher.publishEvent(myRollbackEvent);
    executeDBCode();
}