/**
     * Returns the Jackson {@link JavaType} for the specific class.
     * <p>
     * Default implementation returns {@link TypeFactory#constructType(java.lang.reflect.Type)}, but this can be
     * overridden in subclasses, to allow for custom generic collection handling. For instance:
     *
     * <pre class="code">
     * protected JavaType getJavaType(Class&lt;?&gt; clazz) {
     *  if (List.class.isAssignableFrom(clazz)) {
     *      return TypeFactory.defaultInstance().constructCollectionType(ArrayList.class, MyBean.class);
     *  } else {
     *      return super.getJavaType(clazz);
     *  }
     * }
     * </pre>
     *
     * @param clazz the class to return the java type for
     * @return the java type
     */
    protected JavaType getJavaType(Class<?> clazz) {
        return TypeFactory.defaultInstance().constructType(clazz);
    }