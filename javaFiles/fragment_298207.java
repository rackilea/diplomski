final MutableWrapper<String> stringWrapper = new MutableWrapper<>();
    Mockito.doAnswer(new Answer<Void>() {
        @Override
        public Void answer(InvocationOnMock invocation) throws Throwable {
            stringWrapper.wrap(invocation.getArgumentAt(1, String.class));
            return null;
        }
    }).when(request).setHeader(Matchers.eq(HEADER), Matchers.anyString());

    Mockito.doAnswer(new Answer<Header>() {
        @Override
        public Header answer(InvocationOnMock invocation) throws Throwable {
            Header header = Mockito.mock(Header.class);
            Mockito.when(header.getValue()).thenReturn(stringWrapper.unwrap());
            return header;
        }
    }).when(request).getFirstHeader(Matchers.eq(HEADER));
    return request;
}