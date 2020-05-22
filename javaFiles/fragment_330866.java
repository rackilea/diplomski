public int findSecondMin(int[] arr)
{
    return IntStream.of(arr).boxed().reduce(
        new int[] {Integer.MAX_VALUE, Integer.MAX_VALUE},
        (mins, i) -> {
            return new int[] {Math.min(i, mins[0]), Math.min(Math.max(i, mins[0]), mins[1])};
        }, (mins1, mins2) -> {
            int[] lesser = mins1[0] < mins2[0] ? mins1 : mins2;
            int[] larger = mins1[0] < mins2[0] ? mins2 : mins1;
            return new int[] {lesser[0], Math.min(lesser[1], larger[0])};
        }
    )[1];
}