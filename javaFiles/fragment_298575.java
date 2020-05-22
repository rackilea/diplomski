Type mapStrStr2 = new ParameterizedType() {
    public Type getRawType() {
        return Map.class;
    }
    public Type getOwnerType() {
        return null;
    }
    public Type[] getActualTypeArguments() {
        return new Type[] { String.class, String.class };
    }
};