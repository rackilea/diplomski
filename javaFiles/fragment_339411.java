public Wrapper(Class<Type1> type1Class, Class<Type2> type2Class) {
    this.function = (object1) -> {
        try {
            return type2Class.getConstructor(type1Class).newInstance(object1);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    };
}