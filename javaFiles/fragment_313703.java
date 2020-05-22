public class OverTwentyFourException extends Exception {
    // allow it to handle exceptions with or without a message String
    // the constructor below will call the super's default constructor
    public OverTwentyFourException() {}

    public OverTwentyFourException(String message) {
        super(message);
    }
}