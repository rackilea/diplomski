public static class TestProvider implements Provider<X> {

        private String test;

        private X instance;

        public TestProvider(@Named("my.test.string") String test) {
            this.test = test;
        }

        @Override
        public X get() {
            if(instance == null) {
                instance = new Test(test);
            }
            return instance;
        }

    }