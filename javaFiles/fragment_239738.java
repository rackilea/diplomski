ObjectMapper mapper = new ObjectMapper();
    mapper.setAnnotationIntrospector(new JacksonAnnotationIntrospector() {
        @Override
        public Class<?> findPOJOBuilder(AnnotatedClass ac) {
            if (ExternalClass.class.equals(ac.getRawType())) {
                return ExternalClass.ExternalClassBuilder.class;
            }
            return super.findPOJOBuilder(ac);
        }

        @Override
        public Value findPOJOBuilderConfig(AnnotatedClass ac) {
            if (ac.hasAnnotation(JsonPOJOBuilder.class)) {
                return super.findPOJOBuilderConfig(ac);
            }
            return new JsonPOJOBuilder.Value("build", "");
        }
    });