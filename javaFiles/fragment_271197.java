public class YourClassThatHasTheProblem {
   ...
   private static final Object lock = new Object();
   ... 
    public void createTable(Utils utils, String tableName, RowSerializable row) {
      synchronized (lock) {
        if(!utils.getClient().tableExists(tableName)) {
          this.table = utils.generateTable(tableName, row);
          this.fieldsNames = utils.getNamesOfColumns(table);
         }
       }
  }
 ...
}