class Outer {
    private val bar: Int = 1
    inner class Inner {
        fun getOuter() = this@Outer
        fun foo() = bar
    }
}

val outerObj = Outer().Inner().getOuter()
val bar = Outer().Inner().foo()