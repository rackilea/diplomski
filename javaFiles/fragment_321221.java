public class MyArrayAdapter<T> extends ArrayAdapter<T> 
 {
      HashMap<T, Integer> mIdMap = new HashMap<T, Integer>();

      public MyArrayAdapter(Context context, int textViewResourceId, List<T> objects) {
        super(context, textViewResourceId, objects);
        for (int i = 0; i < objects.size(); ++i) {
          mIdMap.put(objects.get(i), i);
        }
      }
  }