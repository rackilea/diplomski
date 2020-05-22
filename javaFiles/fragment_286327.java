fun main(vararg args: String) {
    val method = Test::class.java.getDeclaredMethod("setNumericListener",
            EditText::class.java, Function1::class.java)

    println(method)
}

// Declarations
class Test {
    private fun setNumericListener(editText: EditText,
            onValueChanged: (d: Double?) -> Unit) {}
}

class EditText {}