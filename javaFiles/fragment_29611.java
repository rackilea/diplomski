class Ex() {
    inline fun <reified T> m() {
        println(T::class)
    }
}

class Ex2() {
    fun m2() {
        Ex().m<Ex2>()
    }
}