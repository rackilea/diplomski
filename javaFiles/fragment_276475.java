public static void printHashMapByEntry(Map<?,?> hm) {
    for(Map.Entry<?,?> entry: hm.entrySet())
    {
        System.out.println(entry.getKey()+" "+entry.getValue());
    }
}