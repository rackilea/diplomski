static public void assertEquals(String message, Object expected, Object actual) {
    if (expected == null && actual == null) {
        return;
    }
    if (expected != null && expected.equals(actual)) {
        return;
    }
    failNotEquals(message, expected, actual); //It calls Part#2
}