public static <T> void sortMaxtrixRows(T[][] mat) { sortMatrixRows(mat, null); }

public static <T> void sortMatrixRows(T[][] mat, Comparator<? super T> comp) {
    for (int i = 0; i < mat.length; i++) {
        Arrays.sort(mat[i], comp);
    }
}