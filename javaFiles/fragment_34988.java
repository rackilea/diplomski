System.out.println(ReflectionToStringBuilder.toString(schema, new RecursiveToStringStyle(5)));

private static class RecursiveToStringStyle extends ToStringStyle {

    private static final int    INFINITE_DEPTH  = -1;

    /**
     * Setting {@link #maxDepth} to 0 will have the same effect as using original {@link #ToStringStyle}: it will
     * print all 1st level values without traversing into them. Setting to 1 will traverse up to 2nd level and so
     * on.
     */
    private int                 maxDepth;

    private int                 depth;

    public RecursiveToStringStyle() {
        this(INFINITE_DEPTH);
    }

    public RecursiveToStringStyle(int maxDepth) {
        setUseShortClassName(true);
        setUseIdentityHashCode(false);

        this.maxDepth = maxDepth;
    }

    @Override
    protected void appendDetail(StringBuffer buffer, String fieldName, Object value) {
        if (value.getClass().getName().startsWith("java.lang.")
                    || (maxDepth != INFINITE_DEPTH && depth >= maxDepth)) {
            buffer.append(value);
        }
        else {
            depth++;
            buffer.append(ReflectionToStringBuilder.toString(value, this));
            depth--;
        }
    }

    // another helpful method
    @Override
    protected void appendDetail(StringBuffer buffer, String fieldName, Collection<?> coll) {
         depth++;
         buffer.append(ReflectionToStringBuilder.toString(coll.toArray(), this, true, true));
         depth--;
    }
}