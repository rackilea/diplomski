private fun Context.fetchName(): String {
    ///...
    return cursor.getString(1)
}

data class DataObject(val id: Int, val name: String) {
    constructor(context: Context, id: Int) : this(id, context.fetchName())
}