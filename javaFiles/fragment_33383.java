public static void main(String[] args) {
    String[] array2 = { "TST1", "TST2", "TST3"};
    List<List<String>> l = new ArrayList<>();
    for (var i: Arrays.asList(0, 1, 2, 3)) {
        l.addAll(nCr(array2, i));
    }
    System.out.println(l);
}

private static List<List<String>> nCr(String[] array, int r) {
    List<List<String>> result = new ArrayList<>();
    if (r == 0) return result;
    if (r == 1) return nC1(array);

    for (int i = 0; i < array.length - r + 1; i++) {
        List<List<String>> result2 = nCr(
                Arrays.copyOfRange(array, i + 1, array.length),
                r - 1);
        for (var x: result2 ) {
            x.add(array[i]);
            result.add(x);
        }
    }
    return result;
}

private static List<List<String>> nC1(String[] array) {
    List<List<String>> l = new ArrayList<>();
    for (var x: array) {
        l.add(new ArrayList<>(Arrays.asList(x)));
    }
    return l;
}