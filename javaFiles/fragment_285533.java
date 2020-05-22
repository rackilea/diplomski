@Async
    public Future<Long> saveEventData(int routeId, String incomingEventMessage, String outgoingEventMessage,
            Timestamp incomingEventTimestamp, Timestamp outgoingEventTimestamp, String userId) throws SQLException {
        String orderId = GenericUtil.extractOrderId(incomingEventMessage);
        EventType eventType = buildEventTypeData(incomingEventMessage);
        EventLog eventLog = eventBuilderService.buildEvent(eventType, routeId, orderId,
                incomingEventMessage, outgoingEventMessage, incomingEventTimestamp, outgoingEventTimestamp);
        long eventId = eventLogDao.save(eventLog, userId);
        if (eventId == 0L) {
            throw new RuntimeException(ERROR_MSG);
        }
        return new AsyncResult<>(eventId);
    }