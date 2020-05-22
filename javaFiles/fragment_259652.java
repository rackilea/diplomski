@RunWith(PowerMockRunner.class)
@PrepareForTest(Scanner.class)
class CoffeeMachineImplementationTest{

@org.junit.Before
public void initializeTest() throws IOException {
    machine = new CoffeeMachineImplementation();
    machineSpy = Mockito.spy(CoffeeMachineImplementation.class);
    doReturn(new Properties()).when(machineSpy).getProperties();
}

@org.junit.Test
public void shouldThrowException_whenNoNextDouble() throws InvalidCoinException {  

    Double input = 0.06;
    String expectedMessage = "expectedMessage";

    Scanner scMock = PowerMock.createMock(Scanner.class)
    machineSpy.setScannerInstance(scMock);

    when(scMock.hasNextDouble()).thenReturn(false);
    when(scMock.next()).thenReturn(input);

    doReturn(expectedMessage).when(machineSpy)
        .getExceptionMessage("invalid.coin", input);   

    try {
        machineSpy.insertCash();
    }

    catch (InvalidCoinException e) {
        assertEquals(expectedMessage, e.getMessage());
    }