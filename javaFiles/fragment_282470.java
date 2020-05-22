when(mockTransactionTemplate.execute(Mockito.<TransactionCallback>any())).thenAnswer(new Answer() {
         public Object answer(InvocationOnMock invocation) {
             Object[] args = invocation.getArguments();
           TransactionCallback arg = (TransactionCallback)args[0];
             return arg.doInTransaction(new SimpleTransactionStatus());
         }
     });     
    when(mockResourceService.callReserve(any(ReserveDetails.class))).thenReturn(reserveInfo);
    when(mockResourceService.callRelease(eq(id))).thenReturn(releaseInfo);

    //Call the exe method
    someService.exe();

    verify(mockResourceService, times(1)).callReserve(any(ReserveDetails.class));
    verify(mockSomeOtherService, times(1)).doSomthing());
    verify(mockMemberResourceService, times(1)).callRelease(eq(id));