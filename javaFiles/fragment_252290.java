ListMultimap<Integer, Thing> multimap =
   Multimaps.index(listOfThings, new Function<Thing, Integer>() {
     public Integer apply(Thing thing) {
       return thing.getCategory();
     }
   });