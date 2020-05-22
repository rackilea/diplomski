public static class HackedParameterModule extends ParameterNamesModule {
        private static final long serialVersionUID = 1L;
        public HackedParameterModule(Mode properties) {
            super(properties);
        }

        @Override
        public void setupModule(SetupContext context) {
            super.setupModule(context);
            context.insertAnnotationIntrospector(new ParameterNamesAnnotationIntrospector(JsonCreator.Mode.DEFAULT, new ParameterExtractor()));
        }
    }