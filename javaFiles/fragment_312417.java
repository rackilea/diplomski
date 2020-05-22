public abstract class GeocodeRequestUrl extends RequestUrl {
    public static abstract class Builder<T extends Builder<T>>
        extends RequestUrl.Builder<Builder<T>>{

        protected Bounds bounds;
        protected String region = "us";

        public Builder(String output, boolean sensor){
            super( output, sensor );
        }

        public T bounds(Bounds bounds){
            this.bounds = bounds;
            return getThis();
        }

        public T region(String region){
            this.region = region;
            return getThis();
        }

        @Override
        public abstract T getThis();
    }

    final private Bounds bounds;
    final private String region;

    protected <T extends Builder<T>> GeocodeRequestUrl(Builder<T> builder){
        super (builder);
        this.bounds = builder.bounds;
        this.region = builder.region;
    }

    // other logic...
}