Genson genson = new GensonBuilder()
            .useIndentation(true)
            .useConstructorWithArguments(true)
            .useRuntimeType(true)
            .addAlias("RainState", RainState.class)
            .useClassMetadata(true)
            .withConverterFactory(new ChainedFactory() {
                @Override
                protected Converter<?> create(Type type, Genson genson, Converter<?> nextConverter) {
                    if (Wrapper.toAnnotatedElement(nextConverter).isAnnotationPresent(HandleClassMetadata.class)) {
                      return new LiteralAsObjectConverter(nextConverter);
                    } else {
                      return nextConverter;
                    }
                }
            }).create();