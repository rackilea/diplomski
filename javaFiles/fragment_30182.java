fun main(args: Array<String>) {
    mutableListOf(1).filterOnCondition(::passedAsCondition)
}


fun <T> MutableList<T>.filterOnCondition(
    condition: KFunction2<@ParameterName(name = "number") Int, @ParameterName(name = "multipleOf") Int, Boolean>
) {
    println(condition.name)
}

fun passedAsCondition(number: Int, multipleOf: Int): Boolean = number % multipleOf == 0