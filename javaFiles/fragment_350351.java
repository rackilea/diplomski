RuntimeException runtimeException = new RuntimeException(message);
    String[] stackTraceRows = stackTrace.split("\n");
    StackTraceElement[] stackTraceElements = new StackTraceElement[stackTraceRows.length];
    for (int i = 0; i < stackTraceRows.length; i++) {
        String[] stackTraceRow = stackTraceRows[i].split("\\|");
        stackTraceElements[i] = new StackTraceElement(stackTraceRow[0], stackTraceRow[1], stackTraceRow[2], Integer.parseInt(stackTraceRow[3]));
    }
    runtimeException.setStackTrace(stackTraceElements);