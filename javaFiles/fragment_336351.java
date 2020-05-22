list.stream().collect(groupingBy(Function.identity(),
  ()->new TreeMap<>(
    // we are effectively grouping by [id, actualCost]
    Comparator.<Foo,Integer>comparing(foo->foo.id).thenComparing(foo->foo.actualCost)
  ), // and aggregating/ summing targetCost
  Collectors.summingInt(foo->foo.targetCost)))
.forEach((group,targetCostSum) ->
    // take the id and actualCost from the group and actualCost from aggregation
    System.out.println(group.id+"\t"+group.actualCost+"\t"+targetCostSum));