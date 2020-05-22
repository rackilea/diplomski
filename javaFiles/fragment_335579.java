public static void allPaths(String a, String b, int i, int j, String s, int[][] arr, List<String> paths) {
    if (i > 0 && j > 0) {
        if (a.charAt(i - 1) == b.charAt(j - 1)) {
            allPaths(a, b, i - 1, j - 1, a.charAt(i - 1) + s, arr, paths);
        } else if (arr[i][j - 1] == arr[i - 1][j]) {
            allPaths(a, b, i, j - 1, s, arr, paths);
            allPaths(a, b, i - 1, j, s, arr, paths);
        } else if (arr[i][j - 1] > arr[i - 1][j]) {
            allPaths(a, b, i, j - 1, s, arr, paths);
        } else if (arr[i][j - 1] < arr[i - 1][j]) {
            allPaths(a, b, i - 1, j, s, arr, paths);
        }
    } else {
        paths.add(s);
    }
}

public static void main(String[] args) {
    String b = "abbaecde";
    String a = "abacbae";

    final List<String> paths = new ArrayList<>();
    allPaths(a, b, a.length(), b.length(), "", twoStringMatrix(a, b), paths);
    System.out.println((paths));
}