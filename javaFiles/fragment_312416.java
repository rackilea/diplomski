public abstract class RequestUrl{
    public static abstract class Builder<T extends Builder<T>>{
        protected String output;
        protected boolean sensor;
        //Optional parameters can have default values
        protected String lang = "en"; 

        public Builder(String output, boolean sensor){
            this.output = output;
            this.sensor = sensor;
        }

        public T lang(String lang){
            this.lang = lang;
            return getThis();
        }

        public abstract T getThis();
    }

    final private String output;
    final private boolean sensor;
    final private String lang;

    protected <T extends Builder<T>> RequestUrl(Builder<T> builder){
        this.output = builder.output;
        this.sensor = builder.sensor;
        this.lang = builder.lang;
    }

    // other logic...
}