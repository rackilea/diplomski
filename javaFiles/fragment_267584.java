invokeAll(
    ids.map(
        new Function<String, Callable<Boolean>>()
        {
            @Override
            public Callable<Boolean> apply(String str)
            {
                return new Callable<Boolean>()
                {
                    @Override
                    public Boolean call() throws Exception
                    {
                        return Boolean.TRUE;
                    }
                };
            }
        }
    )
);