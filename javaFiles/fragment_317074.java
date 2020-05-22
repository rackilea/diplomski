StackTraceElement[] stackTraceElements = e2.getStackTrace();
    String logMessage = "IOException occured in method "
            + stackTraceElements[0].getMethodName() + " - File name is "
            + stackTraceElements[0].getFileName()
            + " - At line number: "
            + stackTraceElements[0].getLineNumber();
    Log.e("InternalStorage", e.getMessage());