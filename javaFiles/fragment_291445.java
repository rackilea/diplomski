class A {
    func sayHello() {
        print("Hello from A")
    }
}

class B<R> : A {
    func sayHi() {
        print("Hi from B")
    }
}

class C<M, R> : B<R> {
    // this fatalError() thing is really ugly, but I can't think of any other workarounds
    func get(r: R) -> [M] { fatalError() }
    func sayGracias() {
        print("Gracias from C")
    }
}

class D : C<String, String> {
    override func get(r: String) -> [String] {
        return [r]
    }
}

let d = D()
d.sayHello()
d.sayHi()
d.sayGracias()
print(d.get(r: "Hello"))