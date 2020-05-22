Integer[] arr1 = new Integer[]{1, 2, 3};
Integer[] arr2 = new Integer[]{4, 5};
Integer[] arr3 = new Integer[]{7};

List<Integer[]> arrays = Arrays.asList(arr1, arr2, arr3);
IntStream.range(0, arrays.stream().mapToInt(a -> a.length).max().orElseThrow())
        .mapToObj(i -> arrays.stream().map(a -> i < a.length ? a[i] : null).collect(Collectors.toList()))
        .forEach(System.out::println);