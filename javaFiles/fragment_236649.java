Class ClassB extends Thread {
    private ClassA classA;

    public ClassB(ClassA classA) {
        this.classA = classA;
    }

    ...
}