List<Number> nums = new ArrayList<>();
    nums.add(1);
    nums.add(2);
    nums.add(3L);
    nums.add(4L);
    nums.add(5.0F);
    nums.add(6.0F);
    nums.add(7.0);
    nums.add(8.0);

    List<Integer> ints = filterList(nums, Integer.class);

    // prints [1, 2]
    System.out.println(Arrays.toString(ints.toArray()));