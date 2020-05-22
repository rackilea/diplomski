open class Foo {

    @Retryable(maxAttempts = 3)
    open fun foo(data: String) :String? {
        println(data)
        throw Exception("foo")
    }

    @Recover
    open fun rec(data: Exception) :String? {
        println("Recovered")
        return null;
    }

}