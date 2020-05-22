public void removeAttributes(XmlObject obj, 
    String[] removeAttributeNames)
        throws IllegalArgumentException, IllegalAccessException,
        InvocationTargetException, SecurityException, 
        NoSuchMethodException {
    Class<?> clazz = obj.getClass();
    for (int i = 0; i < removeAttributeNames.length; i++) {
        String attrName = 
                removeAttributeNames[i].substring(0, 1).toUpperCase() +
                removeAttributeNames[i].substring(1);
        String isSetMethodName = "isSet" + attrName;

        Boolean isSet = null;
        try {
            Method isSetMethod = clazz.getMethod(isSetMethodName);
            isSet = (Boolean) isSetMethod.invoke(obj, new Object[] {});
        } catch (NoSuchMethodException e) {
            System.out.println("attribute " + removeAttributeNames[i]
                    + " is not optional");
        }

        if (isSet != null && isSet.booleanValue() == true) {
            String unsetMethodName = "unset" + attrName;
            Method unsetMethod = clazz.getMethod(unsetMethodName);
            unsetMethod.invoke(obj, new Object[] {});
        }
    }
}