object SQLiteTriggerUtils {

    fun getBeforeDeleteTrigger(mainTable : String,
                               ftsTable : String,
                               rowId : Int?) : String {

        return "CREATE TRIGGER table_bd" +
                " BEFORE DELETE ON $mainTable" +
                " BEGIN DELETE FROM $ftsTable" +
                " WHERE docid=$rowId END;"
    }

    fun getBeforeUpdateTrigger(mainTable: String,
                               ftsTable: String,
                               rowId: Int?) : String {

        return "CREATE TRIGGER table_bu" +
                " BEFORE UPDATE ON $mainTable" +
                " BEGIN DELETE FROM $ftsTable" +
                " WHERE docid=$rowId END;"
    }

    fun getAfterUpdateTrigger(
        mainTable: String,
        ftsTable: String,
        rowId: Int?,
        updatedField: String,
        updatedValue: String?
    ) : String {

        return "CREATE TRIGGER table_au" +
                " AFTER UPDATE ON $mainTable" +
                " BEGIN INSERT INTO $ftsTable(docid, $updatedField)" +
                " VALUES($rowId, $updatedValue) END;"
    }

    fun getAfterInsertTrigger(
        mainTable: String,
        ftsTable: String,
        rowId: Int?,
        updatedField: String,
        updatedValue: String?
    ) : String {

        return "CREATE TRIGGER table_ai" +
                " AFTER INSERT ON $mainTable" +
                " BEGIN INSERT INTO $ftsTable(docid, $updatedField)" +
                " VALUES($rowId, $updatedValue) END;"
    }
}