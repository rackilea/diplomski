public class RowBean implements Comparable<RowBean> {

     private HashMap<String, Object> columns;

     @Override
     public int compareTo(RowBean other) {
          Object valOther = other.columns.get(...);
          Object valMine = columns.get(...);
          return comparison(valOther, valMine);
     }
}