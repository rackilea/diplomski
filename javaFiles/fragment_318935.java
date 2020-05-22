private boolean called = false;

when(mock.nextItem()).thenAnswer(new Answer() {
 Object answer(InvocationOnMock invocation) {   
     called = true;       
     return item;
 }
when(mock.isEmpty()).thenAnswer(new Answer() {
 Object answer(InvocationOnMock invocation) {          
     return called;
 }
});