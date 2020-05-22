class SubA extends BaseA {}
class SubB extends BaseA {}

class ClientA {
    void method(BaseA obj) {
        obj.doSomething();
    }
}
class ClientB<T extends BaseA> {
    void method(T obj) {
        obj.doSomething();
    }
}

ClientA a = new ClientA();
a.method(new SubA());
a.method(new SubB());

ClientB<SubA> b = new ClientB<>();
b.method(new SubA());
b.method(new SubB()); // fails