import java.sql.Array;
import java.sql.Struct;

// getArray() must be modified to return a java.sql.Array, but that should be
// nothing but rs.getArray() (or dataRow.getArray())
Array arr = getArray(dataRow, "FORM_DATA", false);
Map<String, String> kvMap = new HashMap<String, String>();
try {                 
   Struct[] dat = (Struct[])arr.getArray();
   for (Struct s : dat) {
       Object[] element = s.getAttributes();
       String key = (String)element[0];
       String value = (String)element[1];
       kvMap.put(key, value); 
   }
} catch (SQLException e) {
   Log.logError(this, e.getMessage());
}