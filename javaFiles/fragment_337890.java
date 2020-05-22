@Test
public void testMock() throws InterruptedException {
    MyObject myObjectMock = Mockito.mock(MyObject.class);
    doReturn(2).when(myObjectMock).getSomeValue();

    System.out.println(myObjectMock.getSomeValue()); // prints 2
}

private class MyObject {
    public int getSomeValue() {
        return 1;
    }
}