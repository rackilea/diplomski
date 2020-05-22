Set<Field> fields = ReflectionUtils.getAllFields(X.class, new Predicate() {
    public boolean apply(Object input) {
        return true;
    }});
   Map<Field, Object) values = ...
   for(Field f : fields) {
        f.setAccessible(true);
        values.put(f, f.get(obj);
    }