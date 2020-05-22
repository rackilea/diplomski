class A {
    void implementation(Derived stuff) { 
    // Implementation A 
    }
}

class B extends A {
    // contravariant; does not override
    void implementation(Base stuff) { 
    // Implementation B 
    }

    void implementation(Derived stuff) { 
        super.implementation(stuff);
    }
}