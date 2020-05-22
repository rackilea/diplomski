ConcurrentMap<String, Zipper> zippers = list.parallelStream()
    .map(Facet::new)
    .collect( 
        Collectors.groupingByConcurrent(
            Facet::getZip,
            Collector.of( Zipper::new, 
                Zipper::accept, 
                (a,b)-> {a.combine(b); return a; },
                z -> {z.zip(); return z;}
            )
        )
    );