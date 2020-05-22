// Simply creating some 'test' data
Stream<String> test = LongStream.range(0, 10000000L).mapToObj(i -> i + "-test");
// Creating a future for each split to process concurrently
List<Callable<Long>> callableList = new ArrayList<>();
int workChunkTarget = 5000;
Deque<Spliterator<String>> spliterators = new ArrayDeque<>();
spliterators.add(test.parallel().spliterator());
int totalSplits = 0;
while(!spliterators.isEmpty()) {
    Spliterator<String> spliterator = spliterators.pop();
    Spliterator<String> prefix;
    while(spliterator.estimateSize() > workChunkTarget
              && (prefix = spliterator.trySplit()) != null) {
        spliterators.push(spliterator);
        spliterator = prefix;
    }
    totalSplits++;
    callableList.add(new Worker(spliterator, "future-" + totalSplits));
}