public class Util {
    public static void doSomething() {
        for (StackTraceElement stackTrace : Thread.currentThread().getStackTrace()) {
            try {
                TestData annotation = Class.forName(stackTrace.getClassName())
                                           .getDeclaredMethod(stackTrace.getMethodName())
                                           .getAnnotation(TestData.class);
                if (annotation != null)
                    System.out.println("Test data is: " + annotation.value());
            } catch (Exception e) {
                // Ignore
            }
        }
    }
}