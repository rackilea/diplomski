List<String> inputs =
    IntStream.range(0, testCaseNumber)
             .mapToObj(i -> scan.nextLine())
             .collect(Collectors.toList());
// ...
inputs.forEach(input -> doSomething(input));