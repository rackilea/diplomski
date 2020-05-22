catch (NumberFormatException e) {
    RuntimeException runtimeException = new RuntimeException(e);
    e.printStackTrace();
    String serializedException = objectMapper.writeValueAsString(runtimeException);
    System.out.println(serializedException);

    String serializedStackTrace = objectMapper.writeValueAsString(transformStackTrace(runtimeException));
    String serializedStackTraceForCause = objectMapper.writeValueAsString(transformStackTrace(runtimeException.getCause()));

    Throwable throwable = objectMapper.readValue(serializedException, Throwable.class);
    List<CustomStackTraceElement> customStackTraceElementList = objectMapper.readValue(serializedStackTrace, List.class);
    List<CustomStackTraceElement> customStackTraceElementListForCause = objectMapper.readValue(serializedStackTraceForCause, List.class);

    throwable.setStackTrace(reverseTransformStackTrace(customStackTraceElementList));
    throwable.getCause().setStackTrace(reverseTransformStackTrace(customStackTraceElementListForCause));
    throwable.printStackTrace();
}