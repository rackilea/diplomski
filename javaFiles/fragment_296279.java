static int hourglassSums(int[][] arr) {
    return IntStream.range(0, 3).map(x -> {
        return IntStream.range(0, 3).map(y ->
                arr[y][x] + arr[y][x + 1] + arr[y][x + 2] 
                + arr[y + 1][x + 1] 
                + arr[y + 2][x] + arr[y + 2][x + 1] + arr[y + 2][x + 2]
        ).sum();
    }).max().getAsInt();
}