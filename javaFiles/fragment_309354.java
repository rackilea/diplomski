List<String> names = Arrays.asList("A", "B", "C");
Optional<String> match = names.stream()
    .peek(System.out::println)
    .filter(Predicate.isEqual("B"))
    .findFirst();

if(match.isPresent()) System.out.println("Found");
// or
match.ifPresent(s -> System.out.println("Found "+s));

System.out.println("AfterIter");