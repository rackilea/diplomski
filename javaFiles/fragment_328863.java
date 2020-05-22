int m = rows.length;
int n = Arrays.stream(rows).mapToInt(line -> line.length).min().orElse(0);

int[][] columns = IntStream.range(0, n)
    .mapToObj(j -> IntStream.range(0, m)
        .map(i -> rows[i][j])
        .toArray()).toArray(int[][]::new);

System.out.println(Arrays.deepToString(columns));