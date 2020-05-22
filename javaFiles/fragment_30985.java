class MyExclusionStrategy implements ExclusionStrategy {

    public boolean shouldSkipField(FieldAttributes fa) {                
        String className = fa.getDeclaringClass().getName();
        String fieldName = fa.getName();
        return 
            className.equals("my.model.Person")
                && fieldName.equals("lastName");
    }

    @Override
    public boolean shouldSkipClass(Class<?> type) {
        // never skips any class
        return false;
    }
}