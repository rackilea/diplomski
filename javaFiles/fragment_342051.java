class MyException {
    final Reason reason;

    MyException(Reason reason) {
        this.reason = reason;
    }

    // or a class, or whatever you need
    enum Reason {A, B, C}
}