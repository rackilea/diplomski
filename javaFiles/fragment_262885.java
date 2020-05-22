class MyProtocolPrintWriter extends PrintWriter {

    public static final int NORMAL_MESSAGE = 1;
    public static final int ERROR_MESSAGE = 2;

    //put the constructor

    public void writeMessage(String message) {
        println(
            String.format(
            "%02x%02d%s", NORMAL_MESSAGE, message.length(), message));
    }

    public void writeErrorMessage(String message) {
        println(
            String.format(
            "%02x%02d%s", ERROR_MESSAGE, message.length(), message));
    }

}