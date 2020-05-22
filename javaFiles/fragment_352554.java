public static <K extends Comparable<K>,V> List<Entry<K,V>> sortByKeys(Map<K,V> map, final Comparator<K> cmp)
{
    List<Entry<K, V>> ret = new ArrayList<>();
    for(Entry<K,V> kv : map.entrySet())
        ret.add(kv);


    Collections.sort(ret,((Comparator) new Comparator<Entry<K,?>>()
    {
        @Override
        public int compare(Entry<K, ?> o1, Entry<K, ?> o2)
        {
            return cmp.compare(o1.getKey(), o2.getKey());
        }
    }));

    return ret;
}