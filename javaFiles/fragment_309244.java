Map<Integer,Integer> finalMap=Maps.newHashMap();
Multimap<Integer,A> newMap=Multimaps.index(newList, new Function<A,Integer>(){
            public Integer apply(A input) {
                return input.getId();
            }
        });
for(Integer i:newMap.keySet()){
            List<Integer> z=FluentIterable.from(newMap.get(i))
                            .transform(new Function<A,Integer>(){
                                public Integer apply(A input) {
                                    return input.getWeight();
                                }
                            }).toList();
            finalMap.put(i, Collections.max(z));
        }