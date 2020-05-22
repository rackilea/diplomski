static boolean isImmutable(Object obj) {
    Class<?> objClass = obj.getClass();

    // Class of the object must be a direct child class of the required class
    Class<?> superClass = objClass.getSuperclass();
    if (!Immutable.class.equals(superClass)) {
        return false;
    }

    // Class must be final
    if (!Modifier.isFinal(objClass.getModifiers())) {
        return false;
    }

    // Check all fields defined in the class for type and if they are final
    Field[] objFields = objClass.getDeclaredFields();
    for (int i = 0; i < objFields.length; i++) {
        if (!Modifier.isFinal(objFields[i].getModifiers())
                || !isValidFieldType(objFields[i].getType())) {
            return false;
        }
    }

    // Lets hope we didn't forget something
    return true;
}

static boolean isValidFieldType(Class<?> type) {
    // Check for all allowed property types...
    return type.isPrimitive() || String.class.equals(type);
}