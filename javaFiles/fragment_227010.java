interface Types {
    Instantiable<? extends AType<Integer>> SOME_TYPE_0 = new Instantiable<SpecTypeInt>() {
        @Override
        public SpecTypeInt instantiate() {
            return new SpecTypeInt();
        }
    };

    Instantiable<? extends AType<String>> SOME_TYPE_1 = new Instantiable<SpecTypeString>() {
        @Override
        public SpecTypeString instantiate() {
            return new SpecTypeString();
        }
    }  ;
}