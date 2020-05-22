int compare(Comparable key1, Comparable key2) {
   // I'm guessing you are doing something like:
   // return map.get(key1).compareTo(map.get(key2));

    // you can change it to something like
    int result = key1.compareTo(key2);
    if ( result == 0 ) {
      result= key1.compareTo(key2) 
    }

    return result;

}