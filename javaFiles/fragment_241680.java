import java.util.Arrays;
    import org.json.JSONArray;

    public class JsonToArray {
       public static void main(String args[]) throws Exception {
          String [] myArray = [{"key1":1,"key2":"yyy","key3":"4"},{"key1":2,"key2":"xxx","key3":"5"},{"key1":3,"key2":"zzz","key3":"6"}];
          JSONArray jsArray = new JSONArray();
          for (int i = 0; i < myArray.length; i++) {
             jsArray.put(myArray[i]);
         }
         System.out.println(jsArray);
         String[] array = new String[myArray.length];
         for (int i = 0; i < myArray.length; i++) {
            array[i] = (String)jsArray.get(i);
         }
         System.out.println("Contents of the array :: "+Arrays.toString(array));
       }
    }