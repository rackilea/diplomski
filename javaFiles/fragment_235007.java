startTime = new Date(0);
endTime = new Date(Long.MAX_VALUE);

SessionEvent from = new SessionEvent(sessionId, token, startTime);
SessionEvent to = new SessionEvent(sessionId, token, endTime);

RangeBuilder rb = new RangeBuilder().setStart(from).setEnd(to);

OperationResult<ColumnList<SessionEvent>> result = keyspace
        .prepareQuery(CF_SESSION_EVENTS)
        .getKey("UserId1")
        .withColumnRange(rb.build())
        .execute();