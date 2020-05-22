class EvictOnGivenTimestampElement extends Element {

    private static final long serialVersionUID = ...;
    private final long evictOn;

    EvictOnGivenTimestampElement(final Serializable key, final Serializable value, final long evictOn) {
        super(key, value);
        this.evictOn = evictOn;
    }

    @Override
    public boolean isExpired() {
        return System.currentTimeMillis() > evictOn;
    }
}