static boolean getBooleanProperty(final String propName) {
    try {
        boolean answer = AccessController.doPrivileged((java.security.PrivilegedAction<Boolean>) () -> {
                    String propVal = System.getProperty(propName);
                    return "true".equals(propVal.toLowerCase()); // Line 39
                });
        return answer;
    } catch (Exception any) {
    }
    return false;
}