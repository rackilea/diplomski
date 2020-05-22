fun interface Listener {
    fun listen()
}

fun addListener(listener: Listener) = a.listen()

fun main() {
    addListener {
        println("Hello!")
    }
}