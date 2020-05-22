@Test
public void someTest() {
    Logger logger = Mockito.mock(Logger.class);
    EventLogHandler sut = new EventLogHandler(logger);

    sut.handle(event);

    // verify that the right state is extracted from the given event and that the correct marker is used
    Mockito.verify(logger).info(..., ...);
}