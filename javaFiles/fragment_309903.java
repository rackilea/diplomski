abstract class CallBackWithArgument<T> implements Callback<T> {
    String arg;

    CallBackWithArgument(String arg) {
        this.arg = arg;
    }

    CallBackWithArgument() {
    }