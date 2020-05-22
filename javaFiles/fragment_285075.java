MockTest mt = Mockito.spy(new MockTest());
Mockito.when(mt.getAi()).thenReturn(100);

System.out.println(mt.getAi());
mt.increment();
System.out.println(mt.getAi());

// Output will be
// 100
// 100