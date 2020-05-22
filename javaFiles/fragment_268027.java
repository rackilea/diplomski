final AtomicInteger i = new AtomicInteger(0);
when(methodA()).thenAnswer(new Answer<YourType>() {

 @Override
 public YourType answer(InvocationOnMock invocation) {
     return linkedListA.get(i.getAndIncrement());
 }
});