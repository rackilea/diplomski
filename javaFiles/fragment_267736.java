// solution for API < 11
if (Build.VERSION.SDK_INT < Build.VERSION_CODES.HONEYCOMB) {
   for (Entry<String, Object> item : cv.valueSet()) {
      String key = item.getKey(); // getting key
      Object value = item.getValue(); // getting value
      ...
      // do your stuff
   }
}

// solution for API >= 11
if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
   // your current solution
}