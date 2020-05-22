Object obj = "1234";

try {
    int value = ((Integer) obj);
} catch (ClassCastException e) {
    // failed
}