public <T> T getValue(Class<T> returnType, Object obj) throws Exception {
        Class<?> c = obj.getClass();
        Field param = c.getDeclaredField(paramName);
        boolean isAccessible = param.isAccessible();
        param.setAccessible(true);
        Object value = param.get(obj);
        param.setAccessible(isAccessible);
        return returnType.cast(value);
}