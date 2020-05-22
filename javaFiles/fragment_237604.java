int number = 0;

RuntimeException result = number < 0 ? new NumberFormatException() : new RuntimeException();

try {
    throw result;
} catch (NumberFormatException e) {
    throw e;  
} catch (RuntimeException e) {
    // Do nothing
}