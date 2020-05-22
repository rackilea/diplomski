fun getInt(): Int? = ...

fun printInt() {
    val int: Int = getInt() ?: return
    println(int)
}