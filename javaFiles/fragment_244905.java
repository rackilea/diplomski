db.beginTransaction();
try {
  InsertData();
  db.setTransactionSuccessful();
} catch {
  //Error in between database transaction 
} finally {
  db.endTransaction();
}