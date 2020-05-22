class Child extends Client<Child> {
    boolean callSomeChildMethod() {
        return true;
    }

    @Override
    Child getThis() {
        return this;
    }
}