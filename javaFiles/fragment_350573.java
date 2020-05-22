@Test
public void testMyMethodSuccess() {
  Listener mockListener = mock(Listener.class);
  myInstance.myMethod(jsonThatWillSucceed, mockListener);

  verify(mockListener, times(1)).method1();
  verify(mockListener, times(1)).method2(Mockito.eq(expectedResponse));
  verify(mockListener, times(1)).method4();
}