MockTest mt = Mockito.spy(new MockTest());

System.out.println(mt.getAi());
mt.increment();
System.out.println(mt.getAi());

// Output will be
// 0
// 1