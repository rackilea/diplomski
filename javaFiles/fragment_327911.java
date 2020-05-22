class Main {
    companion object {
        @JvmStatic

        fun main(args: Array<String>) = runBlocking {
            val result1 = Main().nonAsyncMethod1(arrayListOf(1, 2, 3, 4, 5))
            result1.elements.forEach { println(it) }
        }
    }

    class Result1(var elements: Collection<String>)

    fun asyncMethod1(x: Collection<Int>, callback: (Result1) -> Unit) {
        Thread().run {
            // do some calculation
            Thread.sleep(1000)
            callback(Result1(x.map { "\"$it\"" }.toList()))
        }
    }

    suspend fun nonAsyncMethod1(entities: Collection<Int>): Result1 = suspendCoroutine {
        cont ->
            asyncMethod1(entities) { cont.resume(it) }
    }
}