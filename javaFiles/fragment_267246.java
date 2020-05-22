public class DoublerTest {

    @Test
    public void testDoubleThatResult() throws Exception {
        int value = 7; // Or any other value
        int returnMock = 13; // Or any other value

        ValueProducer producerMock = mock(ValueProducer.class);
        when(producerMock.getValue(value)).thenReturn(returnMock);

        int actual = Doubler.doubleThatResult(producerMock, value);

        verify(producerMock);
        assertEquals(26, actual);
    }
}