PropertyDescriptor(Class<?> bean, String base, Method read, Method write) throws IntrospectionException {
    if (bean == null) {
        throw new IntrospectionException("Target Bean class is null");
    }
    setClass0(bean);
    setName(Introspector.decapitalize(base));
    setReadMethod(read);
    setWriteMethod(write);
    this.baseName = base;
}