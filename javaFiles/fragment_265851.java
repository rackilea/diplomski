@RunWith(PowerMockRunner.class)
@PrepareForTest({ClassA.class}) //prepare the class creating the new instance of ClassB for test, not the ClassB itself.
public class ClassATest {
    @Test
    public void testAddFromClassA() throws Exception {
        int expected = 15;
        ClassB objB = Mockito.mock(ClassB.class);
        Mockito.when(objB.performCalculation(5, 10)).thenReturn(expected);

        //mocking initialization of ClassB class withing ClassA class
        PowerMockito.whenNew(ClassB.class).withNoArguments().thenReturn(objB);

        ClassA objA = new ClassA();

        //Act
        int actual = objA.add(5, 10);

        //Assert
        assertEquals(expected, actual);
    }
}