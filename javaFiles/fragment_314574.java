int toIndex = 3, fromIndex = 0;
    List<Integer> result = new ArrayList<>();
    while (toIndex < numbers.size()) {
        Map<Integer, Integer> map = IntStream
                .range(fromIndex, toIndex)
                .filter(i->numbers.get(i)>0)
                .mapToObj(i -> new AbstractMap.SimpleEntry<>(i, numbers.get(i)))
                .collect(Collectors.toMap(Map.Entry::getValue, Map.Entry::getKey,(a,b)->b));
        // find max of sublist
        int maxOfSub = numbers.subList(fromIndex, toIndex).stream().max(Integer::compareTo).get();
        //update indexes
        fromIndex = map.getOrDefault(maxOfSub,toIndex-1) + 2;
        toIndex += fromIndex;

        if (maxOfSub > 0)
            result.add(maxOfSub);
    }
    int lastMax = numbers.subList(fromIndex, numbers.size()).stream().max(Integer::compareTo).get();
    if (lastMax > 0)
        result.add(lastMax);
    System.out.println(result);
    System.out.println(result.stream().reduce(0, Integer::sum));