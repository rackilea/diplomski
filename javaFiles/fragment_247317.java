class ClassA {
    private ClassB classB;

    public ClassA(ClassB classB) {
        this.classB = classB;
    }

    public ClassA() : this(new ClassB()) {

    }
}