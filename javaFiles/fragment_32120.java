public void TestClearSessionsMaintainsSessionsUnlessLastAccessTimeIsOverThreshold() {

    final int timeout = 1;
    final String sessionId = "test";
    sessionMgr = GetSessionManagerWithTimeout(timeout);
    DBSession session = CreateSession(sessionMgr, sessionId);

    sessionMgr.clearSessions();
    assertNotNull(sessionMgr.getSession(sessionId));

    session.setAccessTime(PastInstantThatIsOverThreshold()); // MODIFY PRIVATE VARIABLE VIA PROTECTED SETTER
    sessionMgr.clearSessions();
    assertNull(sessionMgr.getSession(sessionId));
}