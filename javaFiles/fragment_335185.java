final Listener listener = ...; // put your listener here
   Foo fooMock = Mockito.mock(Foo.class);

   Mockito.doAnswer( new Answer() {

    @Override
    public Object answer(InvocationOnMock invocation) throws Throwable {
        listener.event(); // this calls your listener
        return null; // actual Method is void, so this will be ignored anyway
    }

   }).when( fooMock.callMethodWhichMayFireAnEvent() );