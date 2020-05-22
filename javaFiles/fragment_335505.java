final Supplier<String> randomSupplier =
    new Supplier<String>() {
        public String get() {
            return Double.toString(Math.random());
        }
    };