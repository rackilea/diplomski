Map<Integer, Map<Integer, Double>> result = ints.stream().collect(
        Collectors.toMap(
                el -> el, 
                el -> catalog.get(el).stream().
                        collect(Collectors.toMap(
                                c -> c.intValue(), 
                                c -> c
                        ))

        )
);
System.out.println(result);
// {1={1=1.1, 2=2.2, 3=3.3, 4=4.4}, 2={1=1.1, 2=2.2, 3=3.3}, 3={1=1.1, 2=2.2}}