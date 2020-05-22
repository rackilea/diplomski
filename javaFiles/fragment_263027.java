static boolean contains (Hashtable <Integer, Vector <String>> map, String value){
    for (Vector<String> values : map.values()){
        if (values.contains(value))
            return true;
    }
    return false;
}