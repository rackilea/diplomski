private static void printMap(HashMap mp) {
    Iterator it = mp.entrySet().iterator();
    while (it.hasNext()) {
        HashMap.Entry pair = (HashMap.Entry)it.next();
        Log.e(TAG, "#253 : "+pair.getKey() + " = " + pair.getValue());
        //it.remove(); // avoids a ConcurrentModificationException
    }
}