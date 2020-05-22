import java.util.Collections;
import java.util.Comparator;
import java.util.Random;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
public class JSONArraySort {
    @SuppressWarnings("unchecked")
    public static void sortASCE(JSONArray array, Object key) {
        Object[] keys = { key };
        Collections.sort(array, new JSONArrayComparator(false, keys));
    }
    @SuppressWarnings("unchecked")
    public static void sortDESC(JSONArray array, Object key) {
        Object[] keys = { key };
        Collections.sort(array, new JSONArrayComparator(true, keys));
    }
    @SuppressWarnings("unchecked")
    public static void sortASCE(JSONArray array, Object[] key) {
        Collections.sort(array, new JSONArrayComparator(false, key));
    }
    @SuppressWarnings("unchecked")
    public static void sortDESC(JSONArray array, Object[] key) {
        Collections.sort(array, new JSONArrayComparator(true, key));
    }
    private static class JSONArrayComparator implements Comparator<JSONObject> {
        private final Object[] KEYS;
        private final boolean DESC;
        public JSONArrayComparator(boolean DESC, Object[] KEYS) {
            this.KEYS = KEYS;
            this.DESC = DESC;
        }
        @Override
        public int compare(JSONObject object1, JSONObject object2) {
            int length = KEYS.length;
            for(int i = 0 ; i < length ; i++){
                String KEY = KEYS[i].toString();
                Object one = object1.get(KEY);
                Object two = object2.get(KEY);
                if(Number.class.isAssignableFrom(one.getClass()) && Number.class.isAssignableFrom(two.getClass())){
                    Double numOne = Number.class.cast(one).doubleValue();
                    Double numTwo = Number.class.cast(two).doubleValue();
                    int compared = 0;
                    if(DESC){
                        compared = numTwo.compareTo(numOne);
                    }else{
                        compared = numOne.compareTo(numTwo);
                    }
                    if(i == KEYS.length - 1 || compared != 0){
                        return compared;
                    }
                }else{
                    int compared = 0;
                    if(DESC){
                        compared = two.toString().compareTo(one.toString());
                    }else{
                        compared = one.toString().compareTo(two.toString());
                    }
                    if(i == KEYS.length - 1 || compared != 0){
                        return compared;
                    }
                }
            }
            // this shouldn't happen.
            return 0;
        }
    }
        //testing...
    public static void main(String... args) {
        JSONArray array1 = new JSONArray();
        for(int i = 0 ; i < 100 ; i++){
            Random random = new Random();
            int num1 = random.nextInt(10);
            int num2 = random.nextInt(10);
            JSONObject object = new JSONObject();
            object.put("num1", num1);
            object.put("num2", num2);
            array1.add(object);
        }
        String[] keys = { "num1", "num2" };
        sortASCE(array1, keys);
        System.out.println(array1.toString());
    }
}