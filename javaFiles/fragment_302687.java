final class FlexiTypeAdapterFactory
        implements TypeAdapterFactory {

    private static final TypeAdapterFactory flexiTypeAdapterFactory = new FlexiTypeAdapterFactory();

    private static final Gson internalGson = new GsonBuilder()
            .registerTypeAdapter(CurveParams.class, getClassAwareSerializer(CurveParams.class, FlexiTypeAdapterFactory::getInternalGson))
            .registerTypeAdapter(EllipticCurve.class, getClassAwareSerializer(EllipticCurve.class, FlexiTypeAdapterFactory::getInternalGson))
            .registerTypeAdapter(GFElement.class, getClassAwareSerializer(GFElement.class, FlexiTypeAdapterFactory::getInternalGson))
            .registerTypeAdapter(Point.class, getClassAwareSerializer(Point.class, FlexiTypeAdapterFactory::getInternalGson))
            .registerTypeAdapter(PrivateKey.class, getClassAwareSerializer(PrivateKey.class, FlexiTypeAdapterFactory::getInternalGson))
            .registerTypeAdapter(PublicKey.class, getClassAwareSerializer(PublicKey.class, FlexiTypeAdapterFactory::getInternalGson))
            .create();

    private FlexiTypeAdapterFactory() {
    }

    static TypeAdapterFactory getFlexiTypeAdapterFactory() {
        return flexiTypeAdapterFactory;
    }

    @Override
    public <T> TypeAdapter<T> create(final Gson gson, final TypeToken<T> type) {
        return internalGson.getAdapter(type);
    }

    private static Gson getInternalGson() {
        return internalGson;
    }

}