List<Integer> nums = Arrays.asList(1, 10, 23, 31, 50, 65, 71, 89, 100);
System.out.println(countLessOrEqual(nums, 50)); // 5
System.out.println(countLessOrEqual(nums, 51)); // 5
System.out.println(countLessOrEqual(nums, 49)); // 4
System.out.println(countLessOrEqual(nums, 0));  // 0
System.out.println(countLessOrEqual(nums, 300)); // 9