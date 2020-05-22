int[][] reversed = IntStream.rangeClosed(1, array.length)
        .mapToObj(i -> array[array.length - i])
        .map(row -> IntStream.rangeClosed(1, row.length)
                .map(i -> row[row.length - i])
                .toArray())
        .toArray(int[][]::new);