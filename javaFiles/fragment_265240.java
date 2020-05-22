interface MySystem {
    PrintStream getOut();
    InputStream getIn();
    ....
}

class MySystemImpl {
    PrintStream getOut() {
        return System.out;
    }
    ...
}