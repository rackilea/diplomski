BitmapDrawable drawable = (BitmapDrawable) imageResult.getDrawable();
Bitmap data = drawable.getBitmap();

ByteArrayOutputStream stream = new ByteArrayOutputStream();
data.compress(CompressFormat.JPEG, 60, stream);

db = dbHelp.getWritableDatabase();
ContentValues cv = new ContentValues();
cv.put("data", stream.toByteArray());

db.insert("table", null, cv);