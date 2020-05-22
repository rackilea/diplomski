static int smallest(int[][] arr){
    return Arrays.stream(arr)
            .flatMapToInt(Arrays::stream)
            .min()
            .orElseThrow(IllegalArgumentException::new);
}