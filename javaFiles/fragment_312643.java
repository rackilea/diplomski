Map<String, Thread> threadMap = new HashMap<String,Thread>();
    threadMap = Collections.synchronizedMap(threadMap);



    YourThread th1 = new YourThread();
            threadMap.put("user1", th);

    YourThread th2 = new YourThread();
            threadMap.put("user2", th);

    YourThread th3 = new YourThread();
            threadMap.put("user3", th);

             ....

    Set<String> userSet = threadMap.keySet();

    Iterator<String> it = userSet.iterator();

    Thread currThread = null;

    while(it.hasNext()){
        String key = it.next();

        currThread = threadMap.get(key);

        // do something with currThread         
    }