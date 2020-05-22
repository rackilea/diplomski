int N = 50;
AtomicReferenceArray<String> strValues = new AtomicReferenceArray<>(N);
IntStream.range(0, N)
        .parallel()
        .forEach(i -> strValues.set(i, Integer.toString(i)));
for (int i = 0; i < strValues.length(); i++) {
    System.out.println(strValues.get(i));
}