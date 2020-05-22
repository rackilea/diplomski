public static void main(final String[] args) throws Exception {
    final Cache cache = CacheManager.getInstance().getCache("smallCache");

    final List<String> list = new ArrayList<String>();
    cache.put(new Element("A", list));

    /* We put in a second element. Since maxElementsInMemory="1", this means
     * that "A" will be evicted from memory and written to disk. */
    cache.put(new Element("B", new ArrayList<String>())); 
    Thread.sleep(2000); // We need to wait a bit, until "A" is evicted.

    /* Imagine, the following happens in Thread 1: */
        final List<String> retrievedList1 =
                   (List<String>) cache.get("A").getValue();
        retrievedList1.add("From Thread 1");

    /* Meanwhile, someone puts something in the cache: */
        cache.put(new Element("C", new ArrayList<String>())); 

    Thread.sleep(2000); // Once again, we wait a bit, until "A" is evicted.

    /* Now the following happens in Thread 2: */
        final List<String> retrievedList2 =
                   (List<String>) cache.get("A").getValue();
        retrievedList2.add("From Thread 2");
        cache.put(new Element("A", retrievedList2));

    /* Meanwhile in Thread 1: */    
        cache.put(new Element("A", retrievedList1));

    /* Now let's see the result: */
    final List<String> resultingList =
                        (List<String>) cache.get("A").getValue();
    for (final String string : resultingList) {
        System.out.println(string);
    } /* Prints only "From Thread 1". "From Thread 2" is lost.
                 But try it with maxElementsInMemory="3", too!! */

    CacheManager.getInstance().shutdown();
}