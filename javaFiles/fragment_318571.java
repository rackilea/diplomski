public <T extends MyType> T foo() {
    return (T)myField;
}


ExtType t = (new MyClass()).foo();