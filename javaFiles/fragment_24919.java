public static boolean arraySameSize(int[][] a, int[][] b) {
    if (a == null && b == null) {
        return true;
    }
    if (a == null || b == null) {
        return false;
    }
    if (a.length != b.length) {
        return false;
    }

    // if the code reaches this point, it means that both arrays are not
    // null AND both have the same length in the first dimension
    for (int i=0; i < a.length; i++) {
        if (a[i] == null && b[i] == null) {
            continue;
        }
        if (a[i] == null || b[i] == null) {
            return false;
        }
        if (a[i].length != b[i].length) {
            return false;
        }
    }

    return true;
}