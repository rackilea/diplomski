Sets.intersection(source_multimap.keySet(), target_multimap.keySet()).forEach(key -> {
    Multiset<String> multiset1 = ImmutableMultiset.copyOf(source_multimap.get(key));
    Multiset<String> multiset2 = ImmutableMultiset.copyOf(target_multimap.get(key));
    System.out.println(key + " has values different: " + Multisets.union(
            Multisets.difference(multiset1, multiset2),
            Multisets.difference(multiset2, multiset1)
    ));
});