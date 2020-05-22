class Example {
    class ClassOne {
    }

    class ClassTwo {
    }

    public <U extends ClassOne> void doStuff(U foo) {
    }

    public <U extends ClassTwo> void doStuff(U foo) {
    }
}