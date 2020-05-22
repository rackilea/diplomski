void callee() {
    if (someTrueCondition()) {
        throw new IllegalArgumentException("whatever");
    }
    System.out.println("this will never get called");
}

void caller() {
    calle(); // the IllegalArgumentException propagates from here
    System.out.println("this will also never get called");
}