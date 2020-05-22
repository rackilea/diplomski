public void caller() {
    callee();
}

public void callee() {
    throw new RuntimeException();
}