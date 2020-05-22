public static int[] unbox(Integer[] wrappers) {
    return Arrays.stream(wrappers).mapToInt(Integer::intValue).toArray();
}

public static float[] unbox(Float[] wrappers) {
    float[] result = new float[wrappers.length];
    IntStream.range(0, wrappers.length).forEachOrdered(
        i -> result[i] = wrappers[i].floatValue());
    return result;
}

// Rest of unbox methods left as an exercise