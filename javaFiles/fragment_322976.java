static public void assertEquals(String message, Object expected, Object actual) {
    if (expected == null && actual == null)
        return;
    if (expected != null && isEquals(expected, actual))
        return;
    else if (expected instanceof String && actual instanceof String) {
        String cleanMessage= message == null ? "" : message;
        throw new ComparisonFailure(cleanMessage, (String)expected, 
                                    (String)actual);
    }
    else
        failNotEquals(message, expected, actual);
    }
}

private static boolean isEquals(Object expected, Object actual) {
    return expected.equals(actual);
}