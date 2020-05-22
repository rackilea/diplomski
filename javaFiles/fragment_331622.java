@Test
public void testInnerHasBeenCalledOnce() throws Exception {

    service.outherMethodName(someParam);

    Mockito.verify(helper, Mockito.times(1)).innerMethodName(someParamSecond);
}