public void TestClearSessionsMaintainsSessionsUnlessLastAccessTimeIsOverThreshold() {

      final int timeout = 1;
      final String sessionId = "test";
      expect(mockClock).GetCurrentTime(); willReturn(CurrentTime());
      sessionMgr = GetSessionManagerWithTimeout(timeout, mockClock);
      DBSession session = CreateSession(sessionMgr, sessionId);

      sessionMgr.clearSessions();
      assertNotNull(sessionMgr.getSession(sessionId));

      expect(mockClock).GetCurrentTime(); willReturn(PastInstantThatIsOverThreshold());
      session.DoSomethingThatUpdatesAccessTime();
      sessionMgr.clearSessions();
      assertNull(sessionMgr.getSession(sessionId));
}