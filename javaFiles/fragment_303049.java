final List<String> messages = new ArrayList<>();

final Answer<Void> catchMeAll = new Answer<Void>()
{
    @Override
    public Void answer(final InvocationOnMock invocation)
    {
        messages.add((String) invocation.getArguments()[0]);
    }
}

doAnswer(catchMeAll).when(logMock).debug(anyString());