private static final Gson gson = new GsonBuilder()
        .addSerializationExclusionStrategy(new ExclusionStrategy() {
            @Override
            public boolean shouldSkipField(final FieldAttributes f) {
                return f.getAnnotation(ReadOnly.class) != null;
            }

            @Override
            public boolean shouldSkipClass(final Class<?> clazz) {
                return false;
            }
        })
        .create();