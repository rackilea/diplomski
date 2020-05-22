public class ReverseGeocodeRequestUrl extends GeocodeRequestUrl {
    public static class Builder<Builder>
        extends GeocodeRequestUrl.Builder<Builder>{

        protected Coord location;

        public Builder(String output, boolean sensor, Coord location){
            super( output, sensor );
            this.location = location;
        }

        @Override
        public Builder getThis(){
            return this;
        }

        public ReverseGeocodeRequestUrl build(){
            return new ReverseGeocodeRequestUrl(this);
        }
    }

    final private Coord location;

    protected ReverseGeocodeRequestUrl(Builder builder){
        super (builder);
        this.location = builder.location;
    }

    // other logic...
}