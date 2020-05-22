class MyExclusionStrategy implements ExclusionStrategy {
    @Override
    public boolean shouldSkipField(FieldAttributes f) {
        //skip all b fields from the XXX class
        return f.getName().equals("b") && f.getDeclaringClass() == XXX.class;
    }
    @Override
    public boolean shouldSkipClass(Class<?> clazz) {
        return false;
    }
}