enum SomeEnum {
        A("one", "two", "three"),
        B("hello", "there");

        public final String[] constants;

        SomeEnum(String... constants) {
            this.constants = constants;
        }
    }