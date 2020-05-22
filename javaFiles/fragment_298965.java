// create the mock appender
Appender mockedAppender = Mockito.mock(Appender.class);

// inject it
((ch.qos.logback.classic.Logger) LoggerFactory.getLogger(Logger.ROOT_LOGGER_NAME)).addAppender(mockedAppender);

// run your test
LoggerFactory.getLogger(Logger.ROOT_LOGGER_NAME).error("Test msg");

// verify using ArgumentCaptor
ArgumentCaptor<Appender> argumentCaptor = ArgumentCaptor.forClass(Appender.class);
Mockito.verify(mockedAppender).doAppend(argumentCaptor.capture());

// assert against argumentCaptor.getAllValues()
Assert.assertEquals(1, argumentCaptor.getAllValues().size());
Assert.assertEquals("Test msg", ((LoggingEvent)argumentCaptor.getAllValues().get(0)).getMessage());

// remove the mock appender from static context
((Logger) LoggerFactory.getLogger(Logger.ROOT_LOGGER_NAME)).detachAppender(mockedAppender);