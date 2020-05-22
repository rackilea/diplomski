fun main() {
   val newString = createString()
   println("String was created " + newString)
}

fun createString(): String {
    println("Hello, world!!!")
    return "new string"
}