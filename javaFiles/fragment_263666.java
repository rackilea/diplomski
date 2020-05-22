public enum DatabaseType {
    FILE(FileDatabase.class),
    SQL(SQLDatabase.class);

    private Database db;

   DatabaseType(Class<Database> db) {
      this.db = db;
   }

   /*package friendly*/ Class<Database> getDatabase() {
      return this.db;
   }
}