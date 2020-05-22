Supplier<Integer> makeCountingLambda() {
    final int[] counter = new int[1];
    return (() -> ++counter[0]);
}

Supplier<Integer> f = makeCountingLambda();
f.get(); // 1
f.get(); // 2