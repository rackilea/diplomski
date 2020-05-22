Entity childrenSeed = byId.apply(100); // e4

Function<Integer, Entity> byParentId = 
    id -> list.stream()
        .filter(e -> id.equals(e.getParentId()))
        .findFirst()
        .orElse(null);

UnaryOperator<Entity> nextChild = 
    e -> e == null ? e : byParentId.apply(e.getId());

List<Entity> children = 
    Stream.iterate(childrenSeed, nextChild)
        .limit(list.size())
        .filter(Objects::nonNull)
        .collect(Collectors.toList()); // [e4, e5, e6]