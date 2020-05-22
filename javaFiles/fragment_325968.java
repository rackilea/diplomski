...
.stream()
.collect(Collectors.toMap(
               A::getName,
               Function.identity(),
               BinaryOperator.maxBy(Comparator.comparing(A::getCreatedDate))))
.values();