//given
SomeService service = new SomeService();
SomeService spy = Mockito.spy(service);
//when
spy.doSecond();
//then
verify(spy).doFirst();