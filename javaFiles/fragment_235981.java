class B {

};

class D : B {

};

class Base {
public:
    virtual B* foo() = 0;
}

class Derived : Base {
public:
    D* foo() {
        return new D();
    }
}