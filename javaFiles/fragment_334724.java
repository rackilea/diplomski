public static class TestProvider implements Provider<X> {

        private String test;

        private X instance;

        @Inject
        public TestProvider(@Named("my.test.string") String test) {
            this.test = test;
        }

        @Override
        public X get() {
            return instance;
        }

    }