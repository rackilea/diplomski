RuntimeException exception = mock(RuntimeException.class);
when(exception.getStackTrace()).thenReturn(
    new StackTraceElement[] {
        new StackTraceElement(
            Claims.class.getCanonicalName(),
            "add",
            "Claims.java",
            123
        )
    }
);