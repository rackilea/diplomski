class Parent {
    abstract String getModelName();

    public void someMethod() {
        String myModel = getModelName();
    }
}

class Child extend Parent {
    String getModelName() { return "events"; }
}