final SQLiteDatabase database = this.openHelper.getWritableDatabase();
try {
    // Begin the transaction
    database.beginTransaction();

    for(Entity entities : viewModels) {

        // Perform your updates here
        ContentValues contentValues = EntityConverter.toContentValues(entity);
        database.update(table, contentValues, "_id = ?", entity.getId());
    }

    // When everything worked set the transaction successful.
    // If you don't call this method the transaction will be rolled back.
    database.setTransactionSuccessful();
} finally {
    // End the transaction
    database.endTransaction();
}