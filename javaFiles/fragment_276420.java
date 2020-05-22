public enum ValueType {
    STRING, INTEGER, BOOLEAN, FLOAT;

    public boolean isInstance(Object obj) {
        // Generate a class name from enum name
        String className = "java.lang."+name().substring(0, 1)+
                               name().substring(1).toLowerCase(Locale.ENGLISH);
        try {
            // Try to resolve this class and check the supplied object type
            return Class.forName(className).isInstance(obj);
        } catch (ClassNotFoundException e) {
            return false;
        }
    }
}