ConcurrentHashMap<Long, Long> millisecondsMap = new ConcurrentHashMap<>();
long key = end / 1000000L;
boolean done = false;
while(!done) {
    Long oldValue = millisecondsMap.putIfAbsent(key, 1L);
    if(oldValue != null) {
        done = millisecondsMap.replace(key, oldValue, oldValue + 1);
    } else {
        done = true;
    }
}