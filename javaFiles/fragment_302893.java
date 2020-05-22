List<Integer> list1 = Arrays.asList(2,4,5);
    List<Integer> list2 = Arrays.asList(2,6,8,9,12,56);

    List<Integer> mergedList = new ArrayList<Integer>();
    mergedList.addAll(list1);
    mergedList.addAll(list2);
    Collections.sort(mergedList);