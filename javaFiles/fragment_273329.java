public static ParameterizedType listTypeWith(Type t) {
    Type[] actual = { t };
    return new ParameterizedType() {

        @Override
        public Type getRawType() {
            return ArrayList.class;
        }

        @Override
        public Type getOwnerType() {
            return null;
        }

        @Override
        public Type[] getActualTypeArguments() {
            return actual;
        }
    };
}