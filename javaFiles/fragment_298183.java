private static List<CustomStackTraceElement> transformStackTrace(Throwable throwable)
{
    List<CustomStackTraceElement> list = new ArrayList<>();
    for (StackTraceElement stackTraceElement : throwable.getStackTrace()) {
        CustomStackTraceElement customStackTraceElement =
            new CustomStackTraceElement(stackTraceElement.getClassName(),
                                        stackTraceElement.getMethodName(),
                                        stackTraceElement.getFileName(),
                                        stackTraceElement.getLineNumber());

        list.add(customStackTraceElement);
    }

    return list;
}