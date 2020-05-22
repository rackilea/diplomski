public String[][] innerJoin(String[][] R, int index1, String[][] S, int index2) {
    // temporary storage for matches
    ArrayList<String[]> matches = new ArrayList<>();

    // loop through both the tables to find out when the join column have common values.
    // output those common values.
    for (int i = 0; i < R.length; i++) {
        for (int j = 0; j < S.length; j++) {
            if (R[i][index1] == S[j][index2]) {
                matches.add(combine(R[i], S[j], index1, index2));
            }
        }
    }

    // convert matches to expected output array
    return matches.toArray(new String[matches.size()][]);
}

private String[] combine(String[] one, String[] two, int index1, int index2) {
    String[] r = new String[one.length + two.length - 1];
    int pos = 0;
    r[pos ++] = one[index1];
    for (int i=0; i<one.length; i++) if (i != index1) r[pos ++] = one[i];
    for (int i=0; i<two.length; i++) if (i != index2) r[pos ++] = two[i];
    return r;
}