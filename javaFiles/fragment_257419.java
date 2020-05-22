internal class MyClass : RectF() {
    companion object {
        @JvmField
        val CREATOR = Parcelable.Creator() { ... }
    }
}