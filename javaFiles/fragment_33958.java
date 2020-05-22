public Foo(IntStream values) { ... }
new Foo(Stream.of(1, 3, 5, 7, 9));

public Foo(int[] values) {  ... }
new Foo(new int[]{1, 3, 5, 7, 9});

public Foo(int... values) { ... }
new Foo(1, 3, 5, 7, 9);

public Foo(List<Integer> values) { ... }
new Foo(Arrays.asList(1, 3, 5, 7, 9));