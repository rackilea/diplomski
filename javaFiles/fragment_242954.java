final SQLiteDatabase database = this.openHelper.getWritableDatabase();
for(Entity entities : viewModels) {        

    // Perform your updates here
    ContentValues contentValues = EntityConverter.toContentValues(entity);
    database.update(table, contentValues, "_id = ?", entity.getId());
}