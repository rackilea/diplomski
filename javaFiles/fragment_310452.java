public static void print(int mat[][]) {
    for (int i = 0; i < mat.length; i++) {
        List<String> stringList = Arrays.stream(mat[i])
                .mapToObj(String::valueOf).collect(Collectors.toList());
        System.out.println(String.join(" ", stringList));
    }
}