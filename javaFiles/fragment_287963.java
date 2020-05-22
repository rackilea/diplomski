private int partition(String[] array, int inicio, int fim) {
    String pivo = array[(inicio + fim) / 2];
    int i = inicio;
    int j = fim;

    while (true) {
        while (array[i].compareTo(pivo) < 0) {
            i++;
        }
        while (array[j].compareTo(pivo) > 0) {
            j--;
        }

        if (i < j) {
            swap(array, i, j);
            i++;
            j--;
        } else {
            return i;
        }
    }
}