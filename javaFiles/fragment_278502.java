MinSpecSetFamily result =
    minRT.specList
         .parallelStream()
         .flatMap(spec -> getMinimalConstSpecTreeRootedAt(spec).getLeaves().stream())
         .map(leaf -> new SpecSet(leaf.getAncestors()))
         .collect(MinSpecSetFamily::new,MinSpecSetFamily::addSpecSet,MinSpecSetFamily::add);