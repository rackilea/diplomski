@Test
@SuppressWarnings("unchecked")
public void fooBarIsInvoked()
{
    final Foo foo = mock(Foo.class);
    final X x = new X(foo);

    // This is to capture the arguments with which foo is invoked
    // FINAL IS NECESSARY: non final method variables cannot serve
    // in inner anonymous classes
    final List<String> captured = new ArrayList<String>();

    // Tell that when foo.bar() is invoked with any list, we want to swallow its
    // list elements into the "captured" list
    doAnswer(new Answer()
    {
        @Override
        public Object answer(final InvocationOnMock invocation)
            throws Throwable
        {
            final List<String> list
                = (List<String>) invocation.getArguments()[0];
            captured.addAll(list);
            return null;
        }
    }).when(foo).bar(anyList());

    // Invoke...
    x.invokeBar();

    // Test invocation...
    verify(foo).bar(anyList());

    // Test arguments: works!
    assertEquals(captured, Arrays.asList("a", "b", "c"));
}