private GetMethod getMethod;

public void testMethod() {
    when(mockHttpClient.executeMethod(any(GetMethod.class))).thenAnswer(new ExecuteMethodAnswer());
    //Execute your tested method here.
    //Acces the getMethod here, assert stuff against it.  
}

private void setResponseStream(HttpMethodBase httpMethod, InputStream inputStream) throws NoSuchFieldException, IllegalAccessException {
    Field privateResponseStream = HttpMethodBase.class.getDeclaredField("responseStream");
    privateResponseStream.setAccessible(true);
    privateResponseStream.set(httpMethod, inputStream);
}

private class ExecuteMethodAnswer implements Answer {
    public Object answer(InvocationOnMock invocation) throws FileNotFoundException,
                                                             NoSuchFieldException, IllegalAccessException {
        getMethod = (GetMethod) invocation.getArguments()[0];
        setResponseStream(getMethod, new FileInputStream(source));
        return HttpStatus.SC_OK;
    }
}