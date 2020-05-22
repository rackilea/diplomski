trait WithConstant {
    final String VALUE = "tim"
}

class MyClass implements WithConstant {
    final String VALUE = "steve"

    def print() {
        println VALUE
    }
}

new MyClass().print()