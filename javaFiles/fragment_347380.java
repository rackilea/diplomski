public void assertEquals(Object actual, Object expected) {
    // Compare Actual and Expected
    if (actual.equals(expected)) {
        System.out.println(actual + " Meets Expected " + expected);
    } else {
        System.out.println(actual + " did not Meet Expected " + expected);
    }
}