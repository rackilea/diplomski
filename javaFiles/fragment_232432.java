@Test
public void canGetCardOperation(){
    CardRepositoryImpl spyImpl = spy(cardRepositoryImpl);
    when(spyImpl.getCardOperation(Mockito.eq("2"), Mockito.anyString()))
        .thenReturn(returnValue);
    // ...
    spyImpl.someOtherMethod();  // Any matching calls to getCardOperation from
                                // someOtherMethod will use the stub above.
}