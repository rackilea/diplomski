Integer[] ints = { 1, 2, 3, 4, 5, 6, 7, 8, 10, 25, 30, 50, 100 };
System.out.println(BinarySearch.Run(ints, 25));
// recognized as: System.out.println(BinarySearch.<Integer>Run(ints, 25));

String[] strings = {"a", "b", "c", "d", "e"};
System.out.println(BinarySearch.Run(strings, "c"));
// recognized as: System.out.println(BinarySearch.<String>Run(strings, "c"));