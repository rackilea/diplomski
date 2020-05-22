List<Integer>nums = Arrays.asList(5,2,35,6);  // or use your enqueue

    Iterator<Integer> it = nums.iterator();

    int min = Integer.MAX_VALUE;
    while (it.hasNext()) {
        Integer i = it.next();
        min = Math.min(i, min);
    }
    System.out.println(min);