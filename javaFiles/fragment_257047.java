abstract class Parent {

   public abstract String getTable();

   public static long getRow() {
      String query = String.format("SELECT * FROM %s WHERE id = ?", getTable()) ;
      //other code...
   }
}

class Child extends Parent {
    public String getTable() {
        return "tableName";
    }
}