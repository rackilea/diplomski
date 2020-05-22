@Mock
Statement statement;

doReturn(statement).when(connection).prepareStatement(anyString());
doNothing().when(statement).setObject(any(), any());
doNothing().when(statement).executeUpdate();