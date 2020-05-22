public static <E> Integer sum(List<E> obejcts, String propertyName) throws 
        IllegalAccessException, 
        InvocationTargetException, 
        NoSuchMethodException {
    Integer sum = 0;
    for (Object o: obejcts) {
        sum += (Integer)PropertyUtils.getProperty(o, propertyName);
    }
    return sum;
}