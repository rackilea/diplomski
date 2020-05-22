private static StackTraceElement[] reverseTransformStackTrace(List<CustomStackTraceElement> customStackTraceElementList)
{
    StackTraceElement[] stackTraceElementArray = new StackTraceElement[customStackTraceElementList.size()];
    for (int i = 0; i < customStackTraceElementList.size(); i++) {
        CustomStackTraceElement customStackTraceElement = customStackTraceElementList.get(i);
        StackTraceElement stackTraceElement =
            new StackTraceElement(customStackTraceElement.getDeclaringClass(),
                                  customStackTraceElement.getMethodName(),
                                  customStackTraceElement.getFileName(),
                                  customStackTraceElement.getLineNumber());

        stackTraceElementArray[i] = stackTraceElement;
    }

    return stackTraceElementArray;
}