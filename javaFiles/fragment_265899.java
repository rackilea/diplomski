private static Random rnd = new Random();
...
public static <K,V> void swapTwoRandomValues(Map<K,V> map){
    if (map.size() <= 1)
        throw new IllegalArgumentException("Not enough items");

    //Choose 2 random positions pos1<pos2
    int pos1 = 0, pos2 = 0;
    while (pos1 == pos2){
        pos1 = rnd.nextInt(map.size());
        pos2 = rnd.nextInt(map.size());
    }       
    if (pos1 > pos2){
        int aux = pos1;
        pos1 = pos2;
        pos2 = aux;
    }

    //Fetch the entries
    Iterator<Map.Entry<K, V>> it = map.entrySet().iterator();
    Map.Entry<K, V> entry1 = null;
    for(int i=0;i <= pos1;i++)
        entry1 = it.next();
    Map.Entry<K, V> entry2 = null;
    for(int i = pos1;i < pos2;i++)
        entry2 = it.next();

    //Swap values
    V tmpValue = entry1.getValue();
    entry1.setValue(entry2.getValue());
    entry2.setValue(tmpValue);
}