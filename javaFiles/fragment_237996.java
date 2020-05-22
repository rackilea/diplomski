open class A {
    fun foo() {
        println("A.foo()")
    }
    companion object {
        fun bar() {
            println("A.Companion.bar()")
        }
    }
}

class B: A()

fun A.foo() {
   println("A.foo() extension")
}

fun A.Companion.bar() {
    println("A.Companion.bar() extension")
}

fun A.Companion.baz() {
    println("A.Companion.baz() extension")
}

fun main(args: Array<String>) {
    A().foo() // prints A.foo()
    A.bar() // prints A.Companion.bar()
    A.baz() // prints A.Companion.baz() extension
    B.bar() // COMPILE ERROR
}