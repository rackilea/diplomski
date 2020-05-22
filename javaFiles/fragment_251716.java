@Test 
public void testFooWithA() {
  when(someMock.foo(eq(whateverA)).thenReturn(bar);
  ...

@Test 
public void testFooWithB() {
  when(someMock.foo(eq(whateverB)).thenReturn(somethingElse);
  ...