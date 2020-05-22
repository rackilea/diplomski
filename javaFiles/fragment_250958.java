SQLiteDatabase mDb=getWritableDatabase();
ContentValues values = new ContentValues();
values.put("column_1", "value_1");
values.put("column_2", "value_2");
long insert_result = mDb.insert(dbSchema.table_name, null, values);
mDb.close();