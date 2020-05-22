@Benchmark
public int[] SystemArraycopyBigger() {
    int i;
    final int length = this.size;
    int[] destination = new int[length * length];
    for(i = 0; i < length; i++) {
        System.arraycopy(this.original, 0, destination, i * length, length);
    }
    return destination;
}

@Benchmark
public int[] StreamArraycopyBigger() {
    int[] destination = Arrays.stream(this.original).flatMap(i -> Arrays.stream(this.original).map(j -> j)).toArray();
    return destination;
}