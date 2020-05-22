public abstract class ListRecognizingBeanInfo
extends SimpleBeanInfo {

    private final BeanDescriptor beanDesc;
    private final PropertyDescriptor[] propDesc;

    protected ListRecognizingBeanInfo(Class<?> beanClass)
    throws IntrospectionException {
        beanDesc = new BeanDescriptor(beanClass);

        List<PropertyDescriptor> desc = new ArrayList<>();

        for (Method method : beanClass.getMethods()) {
            int modifiers = method.getModifiers();
            Class<?> type = method.getReturnType();

            if (Modifier.isPublic(modifiers) &&
                !Modifier.isStatic(modifiers) &&
                !type.equals(Void.TYPE) &&
                method.getParameterCount() == 0) {

                String name = method.getName();
                String remainder;
                if (name.startsWith("get")) {
                    remainder = name.substring(3);
                } else if (name.startsWith("is") &&
                           type.equals(Boolean.TYPE)) {
                    remainder = name.substring(2);
                } else {
                    continue;
                }

                if (remainder.isEmpty()) {
                    continue;
                }

                String propName = Introspector.decapitalize(remainder);

                Method writeMethod = null;
                Method possibleWriteMethod =
                    findMethod(beanClass, "set" + remainder, type);
                if (possibleWriteMethod != null &&
                    possibleWriteMethod.getReturnType().equals(Void.TYPE)) {

                    writeMethod = possibleWriteMethod;
                }

                Class<?> componentType = null;
                if (type.isArray()) {
                    componentType = type.getComponentType();
                } else {
                    Type genType = method.getGenericReturnType();
                    if (genType instanceof ParameterizedType) {
                        ParameterizedType p = (ParameterizedType) genType;
                        if (p.getRawType().equals(List.class)) {
                            Type[] argTypes = p.getActualTypeArguments();
                            if (argTypes[0] instanceof Class) {
                                componentType = (Class<?>) argTypes[0];
                            }
                        }
                    }
                }

                Method indexedReadMethod = null;
                Method indexedWriteMethod = null;

                if (componentType != null) {
                    Method possibleReadMethod =
                        findMethod(beanClass, name, Integer.TYPE);
                    Class<?> idxType = possibleReadMethod.getReturnType();
                    if (idxType.equals(componentType)) {
                        indexedReadMethod = possibleReadMethod;
                    }

                    if (writeMethod != null) {
                        possibleWriteMethod =
                            findMethod(beanClass, writeMethod.getName(),
                                Integer.TYPE, componentType);
                        if (possibleWriteMethod != null &&
                            possibleWriteMethod.getReturnType().equals(
                                Void.TYPE)) {

                            indexedWriteMethod = possibleWriteMethod;
                        }
                    }
                }

                if (indexedReadMethod != null) {
                    desc.add(new IndexedPropertyDescriptor(propName,
                        method, writeMethod,
                        indexedReadMethod, indexedWriteMethod));
                } else {
                    desc.add(new PropertyDescriptor(propName,
                        method, writeMethod));
                }
            }
        }

        propDesc = desc.toArray(new PropertyDescriptor[0]);
    }

    private static Method findMethod(Class<?> cls,
                                     String name,
                                     Class<?>... paramTypes) {
        try {
            Method method = cls.getMethod(name, paramTypes);
            int modifiers = method.getModifiers();
            if (Modifier.isPublic(modifiers) &&
                !Modifier.isStatic(modifiers)) {

                return method;
            }
        } catch (NoSuchMethodException e) {
        }

        return null;
    }

    @Override
    public BeanDescriptor getBeanDescriptor() {
        return beanDesc;
    }

    @Override
    public PropertyDescriptor[] getPropertyDescriptors() {
        return propDesc;
    }
}