String value = "....";
    int size = value.length();
    if (size > Preference.MAX_VALUE_LENGTH) {
      cnt = 1;
      for(int idx = 0 ; idx < size ; cnt++) {
         if ((size - idx) > Preference.MAX_VALUE_LENGTH) {
           pref.put(key + "." + cnt, value.substring(idx,idx+Preference.MAX_VALUE_LENGTH);
           idx += Preference.MAX_VALUE_LENGTH;
         } else {
           pref.put(key + "." + cnt, value.substring(idx);
           idx = size;
         }
      }
   } else {
      pref.put(key, value);
   }