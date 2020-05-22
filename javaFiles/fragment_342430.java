public class ReturnFirstArg<T> implements Answer<T> {
    public T answer(InvocationOnMock invocation) {
        return invocation.getArguments()[0];
    }
}

when(object.method(7)).thenAnswer(new ReturnFirstArg<Integer>());