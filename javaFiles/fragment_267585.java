invokeAll(
    ids.map(
        new Function<String, Callable<Boolean>>()
        {
            @Override
            public Callable<Boolean> apply(String str)
            {
                return Boolean.TRUE;
            }
        }
    )
);