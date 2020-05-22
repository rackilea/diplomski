class Example(fooId: Int) {
    val foo: Foo by supplyAsync { Thread.sleep(2000); fooId }
}

fun main(args: Array<String>) {
    val e = Example(123)
    println(e.foo)
}