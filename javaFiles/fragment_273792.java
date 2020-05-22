static boolean setNumeric(Field field, Object bean, Object value)
throws IllegalAccessException {
    if(!(value instanceof Number)) return false;
    Number n = (Number)value;
    Class<?> type = field.getType();
    if(type.isPrimitive()) {
        if(type == boolean.class || type == char.class) return false;
        switch(type.getName().charAt(0)) {
            case 'b': field.setByte(bean, n.byteValue()); break;
            case 's': field.setShort(bean, n.shortValue()); break;
            case 'i': field.setInt(bean, n.intValue()); break;
            case 'l': field.setLong(bean, n.longValue()); break;
            case 'f': field.setFloat(bean, n.floatValue()); break;
            case 'd': field.setDouble(bean, n.doubleValue()); break;
            default: throw new AssertionError(type);
        }
    }
    else {
        if(!Number.class.isAssignableFrom(type)
        || type.getPackage() != Object.class.getPackage())
            return false;
        switch(type.getSimpleName().charAt(0)) {
            case 'B': field.set(bean, n.byteValue()); break;
            case 'S': field.set(bean, n.shortValue()); break;
            case 'I': field.set(bean, n.intValue()); break;
            case 'L': field.set(bean, n.longValue()); break;
            case 'F': field.set(bean, n.floatValue()); break;
            case 'D': field.set(bean, n.doubleValue()); break;
            default: throw new AssertionError(type);
        }
    }
    return true;
}