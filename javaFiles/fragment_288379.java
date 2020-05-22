@Override
    public Void answer(InvocationOnMock invocation) throws Throwable {
        Object callingObject = invocation.getMock();
        Method method = invocation.getMethod();
        method.invoke(callingObject, /* arguments... */);
        return null;
    }