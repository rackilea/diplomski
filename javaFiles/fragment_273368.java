Class myClass = service.getClass();
    Field myField = getField(myClass, "fieldName");

    TargetClass target = null;
    try {
        target = (TargetClass) myField.get(service);
    } catch (IllegalAccessException e) {
        e.printStatckTrace();
    }

    Class fieldClass = myField.getType();
    try {
        Class[] params = {String.class};
        Method myMethod = fieldClass.getMethod("methodName", params);

        String paramItem = new String("value");
        Object[] paramsObj = {paramItem};
        boolean result = (Boolean) myMethod.invoke(target, paramsObj);         
    } catch ...