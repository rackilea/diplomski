@Mock
private DataSource dataSource;

@Mock
private Connection conn;

...

Mockito.when(dataSource.getConnection()).thenReturn(conn);