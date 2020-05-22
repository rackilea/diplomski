private static final Function<ViewValue, Long> ID_PROJECTION =
    new Function<ViewValue, Long>()
    {
        public Long apply(ViewValue x)
        {
            return x.getId();
        }
    };