public void doSomething(Consumer<LowLevelClass> operation) {
    System.out.println("Doing A");
    for (LowLevelClass entry : classes) {
        System.out.println("Doing something...");
        operation.accept(entry); // or something else...
        System.out.println("Done");
    }
}

public void doSomethingA() {
    return doSomething(LowLevelClass::doSomethingA);
}