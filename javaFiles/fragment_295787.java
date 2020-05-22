checkAndProcessFeed(Feed feed, Map<String, AtomicBoolean> map) {
    while(!map.get(feed.type).compareAndSet(false, true)) // assuming the AtomicBooleans were initialized to false
        Thread.sleep(500);
    }
    process(feed); // at this point map.get(feed.type).get() == true
    map.get(feed.type).set(false); // reset the AtomicBoolean to false
}