Helper helper = mock(Helper.class);
// a and b are the expected parameters
when(helper.doSomethingElse("a", "b")).thenReturn(new Response());
// a and c are not the expected parameters
when(helper.doSomethingElse("a", "c")).thenThrow(new AssertionError());

Delegate delegate = mock(Delegate.class);
// Whatever the parameters provided, simply execute the supplier to 
// get the response to provide and to get an AssertionError if the
// parameters are not the expected ones
when(delegate.methodA(any(), any())).then(
    new Answer<Response>() {
        @Override
        public Response answer(final InvocationOnMock invocationOnMock) throws Throwable {
            return ((Supplier<Response>) invocationOnMock.getArguments()[1]).get();
        }
    }
);

Controller controller = new Controller();
controller.helper = helper;
controller.delegate = delegate;
controller.doSomething();