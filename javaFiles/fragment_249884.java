data class Item(val val1: Long, val val2: Long)

fun main(args: Array<String>) {
    val item = Item(1L, 2L)
    val (first, second) = item
    println("$first, $second")
}