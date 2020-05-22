final class DynamicSerializedNameStrategy
        implements FieldNamingStrategy {

    private final Function<? super String, String> translator;

    private DynamicSerializedNameStrategy(final Function<? super String, String> translator) {
        this.translator = translator;
    }

    static FieldNamingStrategy getDynamicSerializedNameStrategy(final Function<? super String, String> translator) {
        return new DynamicSerializedNameStrategy(translator);
    }

    @Override
    public String translateName(final Field field) {
        final DynamicSerializedName annotation = field.getAnnotation(DynamicSerializedName.class);
        if ( annotation == null ) {
            // Taking the default naming strategy
            // @SerializedName takes higher priority in ReflectiveTypeAdapterFactory.Adapter anyway
            return FieldNamingPolicy.IDENTITY.translateName(field);
        }
        final String key = annotation.value();
        final String resolvedName = translator.apply(key);
        if ( resolvedName == null ) {
            throw new IllegalArgumentException("Cannot resolve name by " + key + " for " + field);
        }
        return resolvedName;
    }

}