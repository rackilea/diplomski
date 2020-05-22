Set<A> set = new HashSet<>();

Set<A> filtered =
    set.stream()
       .map(a -> new A(a.getB().stream().filter(B::isFlag).collect(Collectors.toList())))
       .collect(Collectors.toSet());