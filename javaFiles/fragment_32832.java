Mockito.doAnswer(invocation -> {
    Function1<List<Deal>, Unit> resultListener =
            (Function1<List<Deal>, Unit>) invocation.getArguments()[0];
    Function1<Throwable, Unit> errorListener =
            (Function1<Throwable, Unit>) invocation.getArguments()[1];

    resultListener.invoke(new ArrayList<>());

    return null;
}).when(api).getProductInfo(any(), any());