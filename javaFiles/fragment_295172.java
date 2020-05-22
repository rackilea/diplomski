ExclusionStrategy() {

    public boolean shouldSkipClass(Class<?> clazz) {
        return (clazz == B.class);
    }

    /**
      * Custom field exclusion goes here
      */
    public boolean shouldSkipField(FieldAttributes f) {
        return false;
    }

 }