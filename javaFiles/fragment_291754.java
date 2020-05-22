public static Integer[] box(int[] primitives) {
    return IntStream.of(primitives).boxed().toArray(Integer[]::new);
}

public static Byte[] box(byte[] primitives) {
    return IntStream.range(0, primitives.length).mapToObj(
        i -> primitives[i]).toArray(Byte[]::new);
}

// short, char and boolean left as an exercise

public static Double[] box(double[] primitives) {
    return DoubleStream.of(primitives).boxed().toArray(Double[]::new);
}

public static Float[] box(float[] primitives) {
    return IntStream.range(0, primitives.length).mapToObj(
        i -> primitives[i]).toArray(Float[]::new);
}

public static Long[] box(long[] primitives) {
    return LongStream.of(primitives).boxed().toArray(Long[]::new);
}