@Override
public void run() {

    ObjIntConsumer<Map<Integer, Long>> objIntConsumer = 
            (map, value) -> map.put(value, Iterators.longStream(new CollatzGenerator(value)).count());

    BiConsumer<Map<Integer, Long>, Map<Integer, Long>> biConsumer = 
            (targetMap, accumulatorMap) -> targetMap.putAll(accumulatorMap);

    result = IntStream.range(1, maximum)
            .collect(LinkedHashMap::new, objIntConsumer, biConsumer)
            .entrySet().stream()
            .peek(System.out::println)
            .max(Comparator.<Entry<Integer, Long>>comparingLong(entry -> entry.getValue()))
            .get().getKey();
}