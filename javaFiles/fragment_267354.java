abstract class Base {

    final String errMsg;

    Base(String msg) {
        errMsg = msg;
    }

    abstract String doSomething();
}

class Sub extends Base {

    Sub() {
        super("Sub message");
    }

    String doSomething() {

        return errMsg + " from something";
    }
}