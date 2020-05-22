Integer[] input = {0,1,2,3,4,5,6,7,8,9};
List<Integer> myList = Arrays.asList(input);

Map<Boolean, List<Integer>> map = myList.parallelStream()
        .collect(Collectors.partitioningBy(element -> isSuccess(element)));

List<Integer> passedList = map.get(true);
List<Integer> failedList = map.get(false);