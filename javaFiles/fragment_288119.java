doAnswer(new Answer<Void>() {
    @Override
    public Void answer(InvocationOnMock invocation) throws Throwable {
        Object[] arguments = invocation.getArguments();
        if (arguments != null && arguments.length > 0 && arguments[0] != null) {
            listeners.add((ActionListener) arguments[0]);
        }
        return null;
    }
}).when(mock).addActionListener(Matchers.<ActionListener>any());
doAnswer([..snip..]).when(mock).addActionListener(any(ActionListener.class))