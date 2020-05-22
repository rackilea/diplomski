try {
  useCursor(cursor_id);
} catch(Exception e) {
  genericLogError();
} finally {
  closeCursor(cursor_id);
  closeDatabaseConnection();
}