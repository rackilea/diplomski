Transaction tranaction = Ebean.beginTransaction();
try {
  // turn off persist cascade for this transaction
  transaction.setPersistCascade(false);

  for (C c: listC) {

  }

  Ebean.commitTransaction();

} finally {
  Ebean.endTransaction();
}