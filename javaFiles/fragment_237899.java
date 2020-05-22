import static org.mockito.Mockito.verifyZeroInteractions;

// ...

private PrintStream backup = System.out;

@Before
public void setUp() {
    System.setOut(mock(PrintStream.class));
}

@After
public void tearDown() {
    verifyZeroInteractions(System.out);
    System.setOut(backup);
}