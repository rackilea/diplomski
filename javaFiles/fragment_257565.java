private static String getExceptionDetails(Activity act, Exception e) {
    StackTraceElement[] stackTraceElement = e.getStackTrace();

    String fileName = "";
    String methodName = "";
    int lineNumber = 0;

    try {
        String packageName = act.getApplicationInfo().packageName;
        for (int i = 0; i < stackTraceElement.length; i++) {
            if (stackTraceElement[i].getClassName().startsWith(packageName))
            {
                fileName = stackTraceElement[i].getFileName();
                methodName = stackTraceElement[i].getMethodName();
                lineNumber = stackTraceElement[i].getLineNumber();
                break;
            }
        }
    } catch (Exception e2) {
    }

    return fileName + ":" + methodName + "():line "
            + String.valueOf(lineNumber);
}