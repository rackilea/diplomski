class A {
    func sayHello() {
        print("Hello from A")
    }
}

class B : A {
    func sayHi() {
        print("Hi from B")
    }
}

protocol C {
    // associated types in Swift are kind of like generic parameters for protocols
    associatedtype M
    associatedtype R
    func get(r: R) -> [M]
}

extension C {
    func sayGracias() {
        print("Gracias from C")
    }
}

// You have to specify that D inherits from B as well since protocols can't inherit from classes
class D : B, C {
    typealias M = String
    typealias R = String

    func get(r: String) -> [String] {
        return [r]
    }
}

let d = D()
d.sayHello()
d.sayHi()
d.sayGracias()
print(d.get(r: "Hello"))