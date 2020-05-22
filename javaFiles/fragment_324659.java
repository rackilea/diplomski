public static void main(String[] args) {
    doSomething();
}

private static void doSomething() {
    System.out.println(getCallerClass());
}

private static Class<?> getCallerClass() {
    final StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
    String clazzName = stackTrace[3].getClassName();
    try {
        return Class.forName(clazzName);
    } catch (ClassNotFoundException e) {
        e.printStackTrace();
        return null;
    }
}