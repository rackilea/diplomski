public static int compareVersions(String vers1, String vers2) {
    String[] v1 = vers1.split("\\.");
    String[] v2 = vers2.split("\\.");
    for (int i = 0; i < v1.length && i < v2.length; i++) {
        int i1 = Integer.parseInt(v1[i]);
        int i2 = Integer.parseInt(v2[i]);
        int cmp = Integer.compare(i1, i2);
        if (cmp != 0)
            return cmp;
    }
    return Integer.compare(v1.length, v2.length);
}