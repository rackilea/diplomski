fun main(args: Array<String>) {
    val arr: IntArray = intArrayOf(1,2,3,4)
    val charA: CharArray = charArrayOf('a','b','c','d')

    printMe(arr, IntArray::iterator)
    printMe(charA, CharArray::iterator)

}

fun <T> printMe(args: T, iterator: T.() -> Iterator<*>) {
    for (item in args.iterator()) {
        println(item)
    }
}