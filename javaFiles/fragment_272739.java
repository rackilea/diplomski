ContentResolver contentResolver = new ContentResolver();
contentResolver.applyBatch();
contentResolver.bulkInsert();

ContentProvider contentProvider = new ContentProvider();
contentProvider.applyBatch();
contentProvider.bulkInsert();