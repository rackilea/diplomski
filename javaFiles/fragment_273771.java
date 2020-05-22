public int compare(Map.Entry<K,List<V>> me1, Map.Entry<K,List<V>> me2) {

    List<V> v1 = me1.getValue(); // changed here
    List<V> v2 = me2.getValue(); // changed here

    if(v1.size() > v2.size())
        return 1;
    else if(v1.size() < v2.size())
        return -1;
    else
        return 0;
}