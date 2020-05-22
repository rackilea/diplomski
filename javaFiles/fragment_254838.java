public void testException(String username, String message, String topic, Class<? extends Exception>[] expectedExceptionClasses) {
    try {
        // exception throwing code
    } catch (Exception e) {
        boolean found = false;
        for (Class<?> expectedException : expectedExceptions) {
            if (e instanceof expectedException) {
                found = true;
            }
        }
        if (found) {
            return;
        }
    }
    Assert.fail();
}