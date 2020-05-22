This is the cheat-sheet I compiled.

To compute the cost of a single (key, value) entry:

    If you use HashMap or ConcurrentHashMap, the cost is 8 words (32 bytes)


 So, consider this example from the javadoc:

   LoadingCache graphs = CacheBuilder.newBuilder()
       .maximumSize(10000)
       .expireAfterWrite(10, TimeUnit.MINUTES)
       .removalListener(MY_LISTENER)
       .build(
           new CacheLoader() {
             public Graph load(Key key) throws AnyException {
               return createExpensiveGraph(key);
             }
           });


The cost of an Entry in this structure this is computed as follows:

    It's a Cache: +12 words
    It uses maximumSize(): +4 words
    It uses expiration: +4 words

Thus, each (key, value) entry would have a footprint of 20 words (thus 80 bytes in a 32bit VM, or 160 in a 64bit one). 

To estimate the overhead imposed in the garbage collector, one could count how many references (pointers) each entry introduces, which the garbage collector would have to traverse to compute object reachability. The same list again, this time only counting references:

    If you use HashMap or ConcurrentHashMap, the cost is 5 references