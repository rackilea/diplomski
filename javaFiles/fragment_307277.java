class Example(fooId: Int) {
    private val fooFuture = supplyAsync { httpClient.get(fooId) }

    val foo: Foo
        get() = fooFuture.get()
}