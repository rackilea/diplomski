public enum PossibleClasses {
    CLASS_A(ClassA.class), CLASS_B(ClassB.class);
    Class klass;

    PossibleClasses(Class klass) {
        this.klass = klass;
    }

    static PossibleClasses fromClass(Class desiredClass) {
        for (PossibleClasses current:PossibleClasses.values()) {
            if (current.klass == desiredClass) {
                return current;
            }
        }
        // here you could implement logic regarding class inheritance or something else.
        throw new IllegalArgumentException("Uknown class:"+desiredClass);
    }
}