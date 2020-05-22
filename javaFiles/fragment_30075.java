Stream<MyData> myStream = readData();
final AtomicInteger loader = new AtomicInteger();
int fivePercent = elementsCount / 20;
MyResult result = myStream
    .map(row -> process(row))
    .peek(stat -> {
        if (loader.incrementAndGet() % fivePercent == 0) {
            System.out.println(loader.get() + " elements on " + elementsCount + " treated");
            System.out.println((5*(loader.get() / fivePercent)) + "%");
        }
    })
    .reduce(MyStat::aggregate);