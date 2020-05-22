override fun deleteItem(itemId: Int): Boolean {
        var success : Boolean
        writableDatabase.apply {
            execSQL(SQLiteTriggerUtils.getBeforeDeleteTrigger(TABLE_NAME, FTS_TABLE_NAME, itemId))
            success = delete(TABLE_NAME, "id = ?", arrayOf(itemId.toString())) > 0
            close()
        }
        return success
    }