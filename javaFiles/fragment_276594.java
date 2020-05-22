public class ArrayUtil {

    public static ArrayList<Integer> asList(int[] array) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        if(array != null){
            for(int i=0; i<array.length; ++i){
                list.add(array[i]);
            }
        }
        return list;
    }

}