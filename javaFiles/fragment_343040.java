public boolean containsArray(ArrayList<int[]> listOfArrays, int[] array) {
    for (int[] element : listOfArrays) {
        if (Arrays.equals(element, array)) {
            return true;
        }
    }
    return false;
}