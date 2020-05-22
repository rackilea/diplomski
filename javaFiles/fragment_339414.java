this.function = new Function<Type1, Type2>() {

    @Override
    public Type2 transform(Type1 object1) {
        try {
            return type2Class.getConstructor(type1Class).newInstance(object1);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
};