public abstract class YourExceptionThrowFactory {

    private YourExceptionThrowFactory() {

    }

    public static void throwUsernameInvalidException(String message) {

        throw new UsernameInvalidException(message);
    }