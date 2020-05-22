public Map<A, List<C>> convert(Collection<A> as) {
    List<Long> cIds = as.stream()
            .flatMap(a -> a.getBs().stream())
            .map(B::getIdOfC)
            .collect(Collectors.toList());
    Map<Long, C> csMap = getCsByIds(cIds).stream()
            .collect(Collectors.toMap(C::getId, Function.identity()));

    return as.stream()
            .collect(Collectors.toMap(Function.identity(),
                    a -> a.getBs().stream().map(b -> csMap.get(b.getIdOfC()))
                            .collect(Collectors.toList()), (a, b) -> b));
}