private static StackTraceElement getCallerStackTraceElement(StackTraceElement[] elements) {
    for (int i = 0; i < elements.length; i++) {
        if (elements[i].getClassName().equals(MyLogger.class.getName())) {
            return elements[i + 1];
        }
    }
    return null;
}