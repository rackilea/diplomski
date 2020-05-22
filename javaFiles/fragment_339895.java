fun main(args: Array<String>) {
    val listOfThings = listOf("A", "B", "C", "A", "B", "C")
    val distinctThings = listOfThings.distinct()

    println(listOfThings)  // [A, B, C, A, B, C]
    println(distinctThings)  // [A, B, C]
}