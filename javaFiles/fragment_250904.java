void someMethod(Base obj) {
    if (obj instanceof Derived) { // Just an example, `instanceof` is usually
                                  // an anti-pattern
        Derived d = (Derived)obj;
        // ...
    }
}