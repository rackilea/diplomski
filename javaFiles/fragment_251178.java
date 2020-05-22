doAnswer(new Answer<Void>()
    {
        @Override
        public Void answer(final InvocationOnMock invocation)
            throws Throwable
        {
            final String o = (String) invocation.getArguments()[0];
            myListener.onEvent(o);
            return null;
        }
    }).when((IListener<String>) myListener).onEvent(anyString());