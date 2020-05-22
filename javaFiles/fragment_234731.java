final Class<?> fieldType = field.getType();
if (fieldType.isArray() && !fieldType.getComponentType().isPrimitive()) {
    Object[] fs = (Object[]) f;
    for (Object fi : fs) {
        reflect(fi);
    }
}