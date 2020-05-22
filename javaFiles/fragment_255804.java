final XBaseFile dbf = new XBase().open(new File("..."));
try {
  for (int i = 0; i < dbf.rowCount(); i++) {
    if (dbf.go(i) && !dbf.isDeleted()) {
      final Double x = dbf.getValue("B");
      final Double y = dbf.getValue("C");

      dbf.setValue("C", String.valueOf(x + y));
    }
  }
} finally {
  dbf.closeQuietly();
}