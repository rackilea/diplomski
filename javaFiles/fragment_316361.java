int[] cartesianProduct(int[] one, int[] two) {
    int[] result = new int[one.length * two.length];
    int index = 0;

    for (int v1: one) {
        for (int v2: two) {
            result[index] = v1 * v2;
            index++;
        }
    }

    return result;
}