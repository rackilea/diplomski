public static final Gson PRETTY_PRINT_JSON = new GsonBuilder()
        .addSerializationExclusionStrategy(new ExclusionStrategy()
        {
            @Override
            public boolean shouldSkipField(FieldAttributes f)
            {
                return f.getAnnotation(SkipSerialisation.class) != null;
            }

            @Override
            public boolean shouldSkipClass(Class<?> clazz)
            {
                return false;
            }
        })
        .setPrettyPrinting()
        .create();