AtomicInteger counter = new AtomicInteger(0);
Map<Number,List<Number>> map = sourceList.stream().collect(
    Collectors.groupingBy(it -> {
    int key = counter.getAndIncrement() / (minElementinEachList + 1);
    if(key >= extraElements && (counter.get() + 1) % (minElementinEachList +1 ) == 0){
        counter.getAndIncrement();
    }
    return key;
}));
System.out.println(map);