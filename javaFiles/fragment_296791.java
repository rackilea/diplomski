public static void hashMap(String crnString){
    if (mMap.containsKey(crnString)) {
        int count = mMap.get(crnString);
        count++;
        mMap.put(crnString, count);
    } else {
        mMap.put(crnString, 1);
    }
}