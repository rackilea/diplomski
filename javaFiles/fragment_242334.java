Map<Id,Double> sums = allVs.values ()
                           .stream () 
                           .flatMap (m -> ((Set<IdWrapper>)m.get ("parents")).stream ()
                                                                             .map (i -> new SimpleEntry<Id,Double>(i.getId(),(Double)m.get ("size"))))
                           .collect (Collectors.groupingBy (Map.Entry::getKey,
                                                            Collectors.summingDouble (Map.Entry::getValue)));