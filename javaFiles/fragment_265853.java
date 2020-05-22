@RunWith(PowerMockRunner.class)
public class ClassATest {
    @Test
    public void testAddFromClassA() throws Exception {
        int expected = 15;
        ClassB objB = Mockito.mock(ClassB.class);
        Mockito.when(objB.performCalculation(5, 10)).thenReturn(expected);

        ClassA objA = new ClassA(objB);

        //Act
        int actual = objA.add(5, 10);

        //Assert
        assertEquals(expected, actual);
    }
}