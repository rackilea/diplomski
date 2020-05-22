class A {
    var nonNullable: String? = ""
        get() = field ?: ""
        set(value) {
            if (value != null) {
                field = value
            }
        }
}