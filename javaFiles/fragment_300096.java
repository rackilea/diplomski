Function<Integer, Entity> byId = 
    id -> list.stream()
        .filter(e -> e.getId().equals(id))
        .findFirst()
        .orElse(null);

Entity parentsSeed = byId.apply(100); // e4

UnaryOperator<Entity> nextParent = 
    e -> e == null ? e : byId.apply(e.getParentId());

List<Entity> parents = 
    Stream.iterate(parentsSeed, nextParent)
        .limit(list.size())
        .filter(Objects::nonNull)
        .collect(Collectors.toList()); // [e4, e3, e2, e1]