NavigableSet<Integer> nums = new TreeSet<Integer>(
        Arrays.asList(9,1,5,7,3)
    );

    System.out.println(nums); // "[1, 3, 5, 7, 9]"

    System.out.println(nums.first()); // "1"
    System.out.println(nums.last());  // "9"

    System.out.println(nums.higher(3)); // "5"
    System.out.println(nums.lower(8));  // "7"

    System.out.println(nums.subSet(2,8)); // "[3, 5, 7]"
    System.out.println(nums.subSet(1, true, 5, true));  // "[1, 3, 5]"