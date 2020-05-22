Mockito.doAnswer(new Answer<Void>() {
        @Override
        public Void answer(InvocationOnMock invocation) throws Throwable {
            //DO SOMETHING
            return null;
        }
    }).when(...).remove(Matchers.<String>anyVararg());