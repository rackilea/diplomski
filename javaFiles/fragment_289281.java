interface SomeInterface {
    fun f(a: Int, b: Int): Int
}

val obj = object : SomeInterface {
    override fun f(a: Int, b: Int) = a + b
}