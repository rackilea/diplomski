public static void bubbleSort(int[] A, String TipoOrdenamiento) {
    boolean increasingOrder = TipoOrdenamiento == "Min";
    for (int i = 1; i < A.length; i++) {
        for (int j = A.length - 1; j >= i; j--) {
            if (A[j - 1] < A[j] != increasingOrder && A[j - 1] != A[j]) {
                int aux = A[j - 1];
                A[j - 1] = A[j];
                A[j] = aux;
            }
        }
    }
}