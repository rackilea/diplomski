Predicate<A> ruleA = rule(
    operation(A::getA1, p -> p >= 10),
    operation(A::getA2, p -> p.startsWith("a")),
    operation(A::getA3, p -> p));

List<A> result = listOfA.stream()
    .filter(ruleA)
    .collect(Collectors.toList());