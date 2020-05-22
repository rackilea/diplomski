private static final Gson gson = new GsonBuilder()
        .registerTypeAdapterFactory(new TypeAdapterFactory() {
            @Override
            public <T> TypeAdapter<T> create(final Gson gson, final TypeToken<T> typeToken) {
                if ( !Collection.class.isAssignableFrom(typeToken.getRawType()) ) {
                    return null;
                }
                final TypeAdapter<T> delegateAdapter = gson.getDelegateAdapter(this, typeToken);
                return new TypeAdapter<T>() {
                    @Override
                    public void write(final JsonWriter out, final T value)
                            throws IOException {
                        delegateAdapter.write(out, value);
                    }

                    @Override
                    public T read(final JsonReader in)
                            throws IOException {
                        final boolean wasLenient = in.isLenient();
                        try {
                            in.setLenient(false);
                            return delegateAdapter.read(in);
                        } finally {
                            in.setLenient(wasLenient);
                        }
                    }
                };
            }
        })
        .create();