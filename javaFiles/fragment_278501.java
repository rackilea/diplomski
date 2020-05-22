MinSpecSetFamily result =
    minRT.specList
         .parallelStream()
         .flatMap(spec -> getMinimalConstSpecTreeRootedAt(spec).getLeaves().stream())
         .map(leaf -> new SpecSet(leaf.getAncestors()))
         .reduce(new MinSpecSetFamily (),
                 (fam,set)-> {
                     fam.addSpecSet(set);
                     return fam;
                 },
                 (f1, f2) -> new MinSpecSetFamily(f1, f2));