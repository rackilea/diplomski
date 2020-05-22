@Test
void notCached() throws Exception {
    Callable<Integer> mock = mock(Callable.class);

    when(mock.call()).thenReturn(10);

    Single<Integer> integerSingle = Single.fromCallable(mock);

    Disposable subscribe1 = integerSingle.subscribe();
    Disposable subscribe2 = integerSingle.subscribe();

    verify(mock, times(2)).call();
}

@Test
void cached() throws Exception {
    Callable<Integer> mock = mock(Callable.class);

    when(mock.call()).thenReturn(10);

    Single<Integer> integerSingle = Single.fromCallable(mock).cache();

    Disposable subscribe1 = integerSingle.subscribe();
    Disposable subscribe2 = integerSingle.subscribe();
    Disposable subscribe3 = integerSingle.subscribe();
    Disposable subscribe4 = integerSingle.subscribe();

    verify(mock, times(1)).call();
}