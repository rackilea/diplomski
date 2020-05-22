Set<T> aSet = new HashSet<>(A);

B.stream()
 .filter(b -> !aSet.contains(b))
 .forEach(this::operationY);

B.forEach(this::operationZ);