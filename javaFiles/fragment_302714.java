//example 1: print first element of 1000 after transformations
IntStream.range(0, 1000)
    .peek(System.out::println)
    .mapToObj(String::valueOf)
    .peek(System.out::println)
    .findFirst()
    .ifPresent(System.out::println);

//example 2: check if any value has an even key
boolean valid = records.
    .map(this::heavyConversion)
    .filter(this::checkWithWebService)
    .mapToInt(Record::getKey)
    .anyMatch(i -> i % 2 == 0)