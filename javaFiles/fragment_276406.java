public StableArrayAdapter(Context context, int textViewResourceId,
            List<String> objects) {
          super(context, textViewResourceId, objects);
          for (int i = 0; i < objects.size(); ++i) {  // this will not auto-refresh after 
            mIdMap.put(objects.get(i), i);            // you change items in ArrayList
          }