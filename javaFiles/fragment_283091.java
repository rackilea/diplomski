public static int compareVersions(String vers1, String vers2) {
    String[] v1 = vers1.split("\\.");
    String[] v2 = vers2.split("\\.");
    for (int i = 0; i < v1.length && i < v2.length; i++) {
        String [] w1 = v1[i].split("(?<=\\D)(?=\\d)|(?<=\\d)(?=\\D)");
        String [] w2 = v2[i].split("(?<=\\D)(?=\\d)|(?<=\\d)(?=\\D)");
        for(int j=0;j<w1.length&&j<w2.length;j++) {
            try {
                int i1 = Integer.parseInt(w1[j]);
                int i2 = 0;
                try {
                    i2 = Integer.parseInt(w2[j]);
                } catch (NumberFormatException e) {
                    return -1;
                }
                int cmp = Integer.compare(i1, i2);
                if (cmp != 0)
                    return cmp;
            } catch (NumberFormatException e) {
                try {
                    Integer.parseInt(w2[j]);
                    return +1;
                } catch (NumberFormatException e1) {
                    int cmp = w1[j].compareTo(w2[j]);
                    if (cmp != 0)
                        return cmp;
                }
            }
        }
        int cmp = Integer.compare(w1.length, w2.length);
        if (cmp != 0)
            return cmp;
    }
    return Integer.compare(v1.length, v2.length);
}