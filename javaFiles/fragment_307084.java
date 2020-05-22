Mockito.mock(ObjectNeedToMock.class, new Answer() {
    @Override
    public Object answer(InvocationOnMock invocation) throws Throwable {
        /* 
           Put your default answer logic here.
           It should be based on type of arguments you consume and the type of arguments you return.
           i.e.
        */
        if (String.class.equals(invocation.getMethod().getReturnType())) {
            return "This is my default answer for all methods that returns string";
        } else {
            return RETURNS_DEFAULTS.answer(invocation);
        }
    }
}));