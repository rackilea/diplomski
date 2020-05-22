// note that parameters names might not exist in runtime if code was compiled without a flag to include them.
public void doSomething(String name, int something) {
    MyLib.enterMethod(ThisClass.class, new MethodSignature(void.class, String.class, int.class), new Argument("name", name), new Argument("something", something));
    try {
        // original code
    } finally { // so we don't need to care about return in the middle of original code or exceptions
        MyLib.exitMethod();
    }
}