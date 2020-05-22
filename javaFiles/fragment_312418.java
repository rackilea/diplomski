public class DirectGeocodeRequestUrl extends GeocodeRequestUrl {
    public static class Builder<Builder>
        extends GeocodeRequestUrl.Builder<Builder>{

        protected String address;

        public Builder(String output, boolean sensor, String address){
            super( output, sensor );
            this.address = address;
        }

        @Override
        public Builder getThis(){
            return this;
        }

        public DirectGeocodeRequestUrl build(){
            return new DirectGeocodeRequestUrl(this);
        }
    }

    final private String address;

    protected DirectGeocodeRequestUrl(Builder builder){
        super (builder);
        this.address = builder.address;
    }

    // other logic...
}