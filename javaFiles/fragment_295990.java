data class DataObject(val id: Int, val name: String) {
    object FromCursorFactory {
        fun create(id: Int, context: Context): DataObject {
            val name = context.fetchName()
            return DataObject(id, name)
        }
    }
}