File changeLogFile = new File("...");
FileSystemResourceAccessor accessor = new FileSystemResourceAccessor(changeLogFile.getAbsoluteFile().getParent());

DatabaseConnection db = new JdbcConnection(...);
Liquibase lb = new Liquibase(changeLogFile.getAbsolutePath(), accessor, db);

DatabaseChangeLog changeLog = lb.getDatabaseChangeLog();

List<ChangeSet> changeSets = changeLog.getChangeSets();

for (ChangeSet cs : changeSets) {
  for (Change change : changeSet.getChanges()) {
      if (change instanceof CreateTableChange) {
          // check the table that is created
      }
  }
}