protocol A {
    func hello()
}

class BiA: A {
    func hello() {
        print("Hello")
    }
}

class B2iA: A {
    func hello() {
        print("Hello2")
    }
}

protocol C {
    associatedtype Someclass
    func getAs() -> [Someclass]
}

class D: C {
    typealias Someclass = A
    func getAs() -> [Someclass] {
        return [BiA(), B2iA()]
    }
}

D().getAs().forEach({  $0.hello() })