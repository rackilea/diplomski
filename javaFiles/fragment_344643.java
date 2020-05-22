Object obj = "1234";

try {
    int value = Integer.parseInt((String)obj);
} catch (NumberFormatException e) {
    // failed
}