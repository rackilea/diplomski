// get your database
SQLiteDatabase db = getMySQLiteOpenHelperFromSomewhere().getWritableDatabase();
ContentValues values = new ContentValues();
// The column names here will depend on your schema, of course.
// This would work with:
// CREATE TABLE `signature_table` (`username` VARCHAR, `signature_image` BLOB);
values.put("username", getTheUserName());
values.put("signature_image", byteArray);
db.insert("signature_table", null, values);