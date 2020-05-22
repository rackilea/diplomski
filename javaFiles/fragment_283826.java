public String getSetterName(String property) {
    StringBuilder methodName     = new StringBuilder();
    Character     firstCharacter = Character.toUpperCase(property.charAt(0));

    methodName.append("set").append(firstCharacter).append(property.substring(1));
    return methodName.toString();
}

public void callSetters(Bean bean, String properties[], Object values[]) {
    for (int idx = 0; idx < properties.length; idx++) {
        String property   = properties[idx];
        Object value      = values[idx];
        String setterName = getSetterName(property);

        try {
            Method method = Bean.class.getMethod(setterName);
            method.invoke(bean, value);
        } catch (NoSuchMethodException nsmE) {
            // method doesn't exist for the given property, handle...
        } catch (InvocationTargetException itE) {
            // failed to invoke on target, handle...
        } catch (IllegalAccessException iaE) {
            // can't access method, handle...
        }
    }
}