override fun deleteItem(itemId: Int): Boolean {
        var success : Boolean
        writableDatabase.apply {
            success = delete(TABLE_NAME, "id = ?", arrayOf(itemId.toString())) > 0
            close()
        }
        return success
    }